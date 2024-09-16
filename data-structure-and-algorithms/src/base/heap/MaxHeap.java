package base.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/24
 */
public class MaxHeap {
    private List<Integer> arr;
    public MaxHeap(){
        arr=new ArrayList<>();
    }
    /**
     * 获取左子节点的索引
     */
    int left(int i) {
        return 2 * i + 1;
    }

    /**
     * 获取右子节点的索引
     */
    int right(int i) {
        return 2 * i + 2;
    }

    /**
     * 获取父节点的索引
     */
    int parent(int i) {
        //向下整除
        return (i - 1) / 2;
    }

    /**
     * 访问堆顶元素
     */
    int peek() {
        return arr.get(0);
    }

    /**
     * 交换两节点的值
     */
    void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * 给定元素进行入堆
     */
    void push(int val) {
        //将元素放入数组的末尾
        arr.add(val);
        //进行从底至顶的堆化
        siftUp(arr.size() - 1);
    }

    /**
     * 从指定索引节点开始执行向上堆化
     */
    void siftUp(int i) {
        while (true) {
            //获取父节点索引
            int p = parent(i);
            //如果溢出索引最小值或比父节点的值小就跳出循环
            if (p < 0 || arr.get(i) <= arr.get(p)) {
                break;
            }
            swap(i, p);
            //向上继续堆化
            i = p;
        }
    }

    /**
     * 堆顶元素出堆，为了避免索引全部变化，把堆顶元素与堆尾元素交换，然后再把堆尾元素取出
     */
    int pop() {
        //判断处理
        if (arr.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        //将首尾元素交换
        swap(0, arr.size() - 1);
        //移除尾部节点
        Integer val = arr.remove(arr.size() - 1);
        //此时其他位置是满足堆性质的，从首节点向下进行堆化
        siftDown(0);
        return val;
    }

    /**
     * 从指定索引进行自顶向底堆化
     */
    void siftDown(int i) {
        while (true) {
            //判单当前节点与其子节点最大值
            int max = i, l = left(i), r = right(i);
            if (l < arr.size() && arr.get(l) >= arr.get(max)) {
                max = l;
            }
            if (r < arr.size() && arr.get(r) >= arr.get(max)) {
                max = r;
            }
            //如果i为最大值则满足堆性质跳出
            if (max == i) {
                break;
            }
            swap(i, max);
            //继续向下进行堆化
            i = max;
        }
    }
}

















