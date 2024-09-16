package bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CJW
 * @since 2024/8/21
 */
public class BioServerSingleThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            // 阻塞等待socket连接
            Socket accept = serverSocket.accept();
            System.out.println("获取到连接");
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            //阻塞等待获取数据
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
}
