package com.cnicg.lemon.demo.abknowledge.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerAndClient {
    //https://www.jianshu.com/p/3b7f104e740d
    public static void main(String[] args) throws Exception {

        final int PORT = 6800;
        final String HOST = "127.0.0.1";

        Executors.newCachedThreadPool().submit(() -> {
            try {
                ServerSocketChannel ssc = ServerSocketChannel.open();
                register(ssc);
                ssc.bind(new InetSocketAddress(HOST, PORT));
                while (true) {
                    SocketChannel socketChannel = ssc.accept();
                    ByteBuffer readBuff = ByteBuffer.allocate(1024);
                    int len = socketChannel.read(readBuff);
                    byte[] bytes = new byte[len];
                    readBuff.flip();
                    readBuff.get(bytes, 0, len);
                    System.out.println("server received:" + new String(bytes, Charset.forName("utf-8")));

                    ByteBuffer writeBuff = ByteBuffer.allocate(1024);
                    writeBuff.put("Resp from server".getBytes(Charset.forName("utf-8")));
                    writeBuff.flip();
                    socketChannel.write(writeBuff);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("server started on " + PORT);
        });



        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress(HOST, 6800));

        while (true) {
            TimeUnit.SECONDS.sleep(1);
            ByteBuffer writeBuff2 = ByteBuffer.allocate(1024);
            writeBuff2.put("Req from client".getBytes(Charset.forName("utf-8")));
            writeBuff2.flip();
            channel.write(writeBuff2);

            System.out.println("client send success");
            TimeUnit.SECONDS.sleep(1);
            ByteBuffer readBuff2 = ByteBuffer.allocate(1024);
            int len2 = channel.read(readBuff2);
            System.out.println("len is " + len2);
            byte[] bytes = new byte[len2];
            readBuff2.flip();
            readBuff2.get(bytes, 0, len2);
            System.out.println("client received:" + new String(bytes, Charset.forName("utf-8")));

            TimeUnit.SECONDS.sleep(3600);

        }


    }


    public static void register(AbstractSelectableChannel channel) throws Exception {
        //macOS默认为KQueueSelectorImpl, KQueue与Epoll非常类似
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_CONNECT);
    }


}
