package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CJW
 * @since 2024/8/22
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        //创建选择器
        Selector selector = Selector.open();

        //将通道注册到选择器上
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //通道必须设置为非阻塞，否则通道的某个时间阻塞了服务器就不能相应其他事件了，选择器失去了意义
        serverSocketChannel.configureBlocking(false);
        //为管道注册选择器和具体事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress( 9999);
        serverSocket.bind(inetSocketAddress);

        while (true) {
            //监听使事件，会一直阻塞直到至少一个事件到达
            selector.select();
            //获取事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    //获取这个key被那个channel创建的
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                    //为新连接创建一个socketChannel并注册选择器和事件类型
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromChannel(socketChannel));
                    socketChannel.close();
                }
                keyIterator.remove();
            }
        }
    }

    private static String readDataFromChannel(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();
        while (true) {
            buffer.clear();
            int read = socketChannel.read(buffer);
            if (read == -1) {
                break;
            }
            //切换为读取
            buffer.flip();
            //获取当前可读取的字节数
            int limit = buffer.limit();
            byte[] dst = new byte[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = buffer.get(i);
            }
            data.append(new String(dst, StandardCharsets.UTF_8));
            buffer.clear();
        }
        return data.toString();
    }
}
