package reactor;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author CJW
 * @since 2024/8/22
 */
public class Acceptor implements Runnable {
    private final ExecutorService executor = Executors.newFixedThreadPool(20);
    private final ServerSocketChannel serverSocketChannel;

    public Acceptor(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        try {
            // 获取客户端连接
            SocketChannel channel = serverSocketChannel.accept();
            if (null != channel) {
                // 将客户端连接交由线程池处理
                executor.execute(new Handler(channel));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
