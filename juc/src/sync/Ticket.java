package sync;

/**
 * @author CJW
 * @since 2024/3/5
 */
public class Ticket {
    private int number=100;
    public synchronized void sale(){
        if (number>0){
            number--;
            System.out.println(Thread.currentThread().getName()+"卖出一张  剩余票数："+number);
        }
    }
}
