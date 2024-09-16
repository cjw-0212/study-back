package leetbook_ioa;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author CJW
 * @since 2024/8/16
 */
public class LCR160 {
    private Queue<Integer> A;
    private Queue<Integer> B;

    public LCR160() {
        //利用两个堆将数据分为两半，小顶堆存放较大一半，大顶堆存放较小一半
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        //此时总数为偶数个，向较小部分添加
        if (A.size() == B.size()) {
            B.offer(num);
            A.offer(B.poll());
        } else {
            //此时总数为奇数个，较小部分多一个，应往较大部分添加
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (B.peek() + A.peek()) / 2.0 : A.peek();
    }
}
