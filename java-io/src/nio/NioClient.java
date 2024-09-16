package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author CJW
 * @since 2024/8/22
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5000; i++) {
            new Thread(()->{
                try (Socket socket = new Socket("127.0.0.1", 9999)) {
                    OutputStream outputStream = socket.getOutputStream();
                    String message=Thread.currentThread().getName()+"发来问好";
                    outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                    System.out.println(Thread.currentThread().getName()+"发送了问好");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }
    }
}
