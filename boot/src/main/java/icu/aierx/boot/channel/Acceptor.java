package icu.aierx.boot.channel;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Acceptor {
	
	public static void main(String[] args) {
		try {
			HashMap<Integer, String> map = new HashMap<>();
			List<SocketChannel> list = new ArrayList<>();
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.bind(new InetSocketAddress(9090));
			ssc.configureBlocking(false);
			Selector selector = Selector.open();
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			while (true) {
				selector.select(2000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext()) {
					selector.wakeup();
					SelectionKey key = iterator.next();
					if (key.isAcceptable()) {
						SocketChannel sc = ssc.accept();
						sc.configureBlocking(false);
						list.add(sc);
						System.out.println("[client connected]: " + sc.getRemoteAddress());
						sc.register(selector, SelectionKey.OP_READ);
					} else if (key.isReadable()) {
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
						SocketChannel channel = (SocketChannel) key.channel();
						int len = channel.read(byteBuffer);
						channel.configureBlocking(false);
						String data = new String(byteBuffer.array(), 0, len, StandardCharsets.UTF_16BE);
						if (map.get(channel.hashCode()) == null) {
							map.put(channel.hashCode(), data);
							System.out.println("[" + data + "]: 已登陆");
							ByteArrayAttachment attachment = new ByteArrayAttachment("1", "user login".getBytes(),
									"text/html");
							channel.register(selector, SelectionKey.OP_WRITE,ByteBuffer.allocate(1024));
						} else {
							String name = map.get(channel.hashCode());
							System.out.println("[" + name + "]: " + data);
							ByteArrayAttachment attachment = new ByteArrayAttachment("1", data.getBytes(), "text" +
									"/html");
							channel.register(selector, SelectionKey.OP_WRITE, ByteBuffer.allocate(1024));
						}
						channel.register(selector, SelectionKey.OP_WRITE);
					} else if (key.isWritable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						for (SocketChannel socketChannel : list) {
							if (channel != socketChannel) {
								Object attachment = key.attachment();
								socketChannel.write(ByteBuffer.wrap(attachment.toString().getBytes()));
							}
						}
						channel.register(selector, SelectionKey.OP_READ);
					}
					iterator.remove();
					
				}
			}
		} catch (Exception e) {
		}
	}
}
