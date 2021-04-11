package top.chenxuebing.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chen.xuebing
 * @date 2021/3/30 21:46
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",9001));
        serverSocketChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        List<SocketChannel> socketChannelList = new LinkedList();
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel != null) {
                socketChannel.configureBlocking(false);
                socketChannelList.add(socketChannel);
                for (SocketChannel channel : socketChannelList) {
                    System.out.println(channel.toString());
                    channel.read(byteBuffer);
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.limit()];
                    for (int i = 0; i < byteBuffer.limit(); i++) {
                        bytes[i] = byteBuffer.get(i);
                    }
                    System.out.println(new String(bytes));
                    byteBuffer.clear();
                }
            }
        }
    }
}
