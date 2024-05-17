/**
 * @author CJW
 * @since 2024/3/5
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isDaemon());
            while (true) {

            }
        });
        //如果主线程结束，剩下的是守护线程，jvm会结束，剩下用户线程jvm不结束
        //
        // t.setDaemon(true);
        t.start();
        System.out.println(Thread.currentThread().getName()+":"+"over");
    }
}
