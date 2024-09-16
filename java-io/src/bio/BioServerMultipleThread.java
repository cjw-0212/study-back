package bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author CJW
 * @since 2024/8/21
 */
public class BioServerMultipleThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("获取到连接");
            threadPoolExecutor.execute(() -> {
                try {
                    solve(accept);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static void solve(Socket accept) throws IOException {
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String message;
        //如果客户端中建立连接不发送数据，就会一直阻塞，就会一直占用线程
        while ((message = bufferedReader.readLine()) != null) {
            System.out.println("接收到数据：" + message);
            if ("end".equals(message)) {
                OutputStream outputStream = accept.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write("服务端已关闭连接\n");
                bufferedWriter.flush();
                accept.close();
                break;
            }
        }
        System.out.println("一次连接处理完成，等待下一次连接");
    }
}
