package base.sort;

/**
 * @author CJW
 * @since 2024/7/24
 */
public class HeapSort implements SortStrategy {
    /**
     * 堆排序<br>
     * 1、将带排序的序列构造成一个大顶堆，根据大顶堆的性质，当前堆的根节点（堆顶）就是序列中最大的元素；<br>
     * 2、将堆顶元素和最后一个元素交换，然后将剩下的节点重新构造成一个大顶堆；<br>
     * 3、重复步骤2，如此反复，从第一次构建大顶堆开始，每一次构建，我们都能获得一个序列的最大值，然后把它放到大顶堆的尾部。最后，就得到一个有序的序列了。<br>
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     *
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        //建堆操作，建立大顶堆
        //从倒数第一个非叶子节点开始执行自顶向下的堆化
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        //循环n-1次每次将最大值与尾节点交换
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            siftDown(nums, i, 0);
        }
    }

    /**
     * 从指定索引开始进行自顶向下的堆化
     *
     * @param n 堆的长度
     */
    private static void siftDown(int[] nums, int n, int i) {
        while (true) {
            //找出节点与其字节点三者之间的最大值
            int max = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n && nums[l] > nums[max]) {
                max = l;
            }
            if (r < n && nums[r] > nums[max]) {
                max = r;
            }
            //若当前节点就是最大值则完成堆化
            if (max == i) {
                break;
            }
            //交换节点
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
            //向下循环
            i = max;
        }
    }
}
