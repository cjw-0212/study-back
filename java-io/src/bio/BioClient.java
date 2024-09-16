package bio;

import java.io.*;
import java.net.Socket;

/**
 * @author CJW
 * @since 2024/8/21
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                BioClient bioClient = new BioClient();
                try {
                    bioClient.run();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, String.valueOf(i)).start();
        }
    }

    public void run() throws IOException {
        Socket socket = null;
        InputStream inputStream;
        OutputStream outputStream;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            socket = new Socket("127.0.0.1", 9999);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            System.out.println(Thread.currentThread().getName() + "与服务端进建立连接");
            System.out.println(Thread.currentThread().getName() + "给服务端发送消息");
            //BufferedReader读的是一行，读到换行符才停止。
            // 由于我用BufferedWriter写出时没有加换行符，所有服务端的BufferedReader由于读不到换行符一直等待，导致程序卡住。
            bufferedWriter.write("hello\n");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "间隔两秒给服务端再次发送消息");
            bufferedWriter.write("end\n");
            //将缓冲流数据刷新出去
            bufferedWriter.flush();
            String message;
            System.out.println(Thread.currentThread().getName() + "阻塞等待服务端返回数据");
            //阻塞等待获取数据
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + "得到返回数据：" + message);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null) {
                socket.close();

            }
        }
    }
}
