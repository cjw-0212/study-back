package lock;

/**
 * @author CJW
 * @since 2024/3/5
 */
public class LsaleTicket {
    public static void main(String[] args) {
        Lticket lticket=new Lticket();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                lticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                lticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                lticket.sale();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                lticket.sale();
            }
        },"D").start();
    }
}
