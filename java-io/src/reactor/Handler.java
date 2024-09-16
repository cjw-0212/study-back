package reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CJW
 * @since 2024/8/22
 */
public class Handler implements Runnable {
    private volatile ByteBuffer inputBuffer = ByteBuffer.allocate(1024);
    private volatile ByteBuffer outputBuffer = ByteBuffer.allocate(1024);
    private static volatile Selector selector;
    private final SocketChannel socketChannel;
    private SelectionKey key;

    public Handler(SocketChannel socketChannel) throws IOException {
        selector = Selector.open();
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        key = socketChannel.register(selector, SelectionKey.OP_READ);
    }

    @Override
    public void run() {
        try {
            while (selector.isOpen() && socketChannel.isOpen()) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isReadable()) {
                        read(key);
                    } else if (key.isWritable()) {
                        write(key);
                    }
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(SelectionKey key) throws IOException {
        outputBuffer.compact();
        if (socketChannel.isOpen()) {
            socketChannel.write(outputBuffer);
            socketChannel.close();
            outputBuffer.clear();
        }
    }

    private void read(SelectionKey key) throws IOException {
        socketChannel.read(inputBuffer);
        if (inputBuffer.position() == 0) {
            return;
        }
        inputBuffer.flip();
        process();
        inputBuffer.clear();
        //读取完成后监听写入事件
        key.interestOps(SelectionKey.OP_WRITE);
    }


    private Set<SelectionKey> select() throws IOException {
        selector.select();
        Set<SelectionKey> keys = selector.selectedKeys();
        if (keys.isEmpty()) {
            int interestOps = key.interestOps();
            selector = Selector.open();
            key = socketChannel.register(selector, interestOps);
            return select();
        }

        return keys;
    }

    /**
     * 进行业务处理，如果成为性能瓶颈可以放入线程池处理
     */
    private void process() {
        byte[] bytes = new byte[inputBuffer.remaining()];
        inputBuffer.get(bytes);
        String message = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("收到客户端消息：" + message);
        //写出数据
        outputBuffer.put("你好，客户端".getBytes(StandardCharsets.UTF_8));
    }
}
