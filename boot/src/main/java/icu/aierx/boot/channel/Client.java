package icu.aierx.boot.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * @author leiwenyong
 * @since 2023-01-09
 */
public class Client extends Thread{
	
	@Override
	public void run() {
		super.run();
	}
	
	public static void main(String[] args) throws Exception {
		CharsetDecoder decoder = Charset.forName("UTF_16BE").newDecoder();
		CharsetEncoder encoder = Charset.forName("UTF_16BE").newEncoder();
		
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		SelectionKey key = socketChannel.register(selector, SelectionKey.OP_CONNECT);
		
		socketChannel.connect(new InetSocketAddress("localhost", 9090));
		
		while (true) {
			selector.select();
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey next = it.next();
				it.remove();
				if (next.isConnectable()) {
					SocketChannel channel = (SocketChannel) next.channel();
					if (channel.isConnectionPending())
						channel.finishConnect();
					channel.register(selector, SelectionKey.OP_READ);
					System.out.println("连接成功");
					SocketChannel channel1 = (SocketChannel) key.channel();
					channel1.write(encoder.encode(CharBuffer.wrap("hello")));
				} else if (next.isReadable()) {
					SocketChannel channel = (SocketChannel) next.channel();
					ByteBuffer buffer = ByteBuffer.allocate(50);
					channel.read(buffer);
					buffer.flip();
					String msg = decoder.decode(buffer).toString();
					System.out.println("[receive]: " + msg);
				}
			}
		}
	}
}
