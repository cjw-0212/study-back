package base.heap;

import base.sort.InsertSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/24
 */
public class Test {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.push(0);
        maxHeap.push(6);
        maxHeap.push(3);
        maxHeap.push(9);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());
    }
}
