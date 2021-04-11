package top.chenxuebing.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author chen.xuebing
 * @date 2021/3/30 22:05
 */
public class client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        ByteBuffer byteBuffer = ByteBuffer.wrap("哈哈".getBytes(StandardCharsets.UTF_8));
        socketChannel.connect(new InetSocketAddress("localhost", 9001));
        socketChannel.write(byteBuffer);
    }
}
