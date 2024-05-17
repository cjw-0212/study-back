package lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author CJW
 * @since 2024/3/10
 */
public class Lock_8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone=new Phone();
        Phone phone1=new Phone();
        /**
         * 1、标准访问先短信后邮件
         *    发送短信
         *    发送邮件
         *
         * 2、发短信前停四秒
         *    发送短信
         *    发送邮件
         *
         * 3、停四秒发短信和普通的hello方法
         *    打招呼
         *    发送短信
         *
         * 4、两部手机分别调用
         *   发送邮件
         *   发送短信
         *
         * 5、一手机两个静态同步方法
         *    发送短信
         *    发送邮件
         *
         * 6、两手机两个静态同步方法
         *    发送短信
         *    发送邮件
         *
         * 7、一手机一静态同步一普通同步
         *    普通先
         *    发送邮件
         *    发送短信
         *
         * 8、两手机一静态同步一普通同步
         *   发送邮件
         *   发送短信
         */
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();

        //不是调用start线程立即创建，停止一下确保先短信
        Thread.sleep(1000);

        new Thread(()->{
            phone1.sendMail();
        }).start();
    }
}

class Phone {
    public static synchronized void sendSMS() throws InterruptedException {
        System.out.println("发送短信");
    }

    public  synchronized void sendMail() {
        System.out.println("发送邮件");
    }

    public void getHello() {
        System.out.println("打招呼");
    }


}
