package icu.aierx.netty.nio;

import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try {
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8080));
            ssc.configureBlocking(false);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                if (selector.select(3000)==0){
                    System.out.println("==");
                    continue;
                }
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()){
                        handleAccept(key);
                    }
                    if (key.isReadable()){
                        handlerRead(key);
                    }
                    if (key.isWritable()&&key.isValid()){
                        handlerWrite(key);
                    }
                    if (key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    iter.remove();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(selector!=null){
                    selector.close();
                }
                if (ssc!=null){
                    ssc.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private static void handlerWrite(SelectionKey key) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while (buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }

    private static void handlerRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer)key.attachment();
        int byteRead = sc.read(buf);
        while (byteRead>0){
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }
            System.out.println();
            buf.clear();
            byteRead = sc.read(buf);
        }
        if (byteRead == -1){
            sc.close();
        }

    }

    private static void handleAccept(SelectionKey key)throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocateDirect(1024));
    }
}
