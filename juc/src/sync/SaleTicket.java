package sync;

/**
 * @author CJW
 * @since 2024/3/5
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"D").start();
    }
}

