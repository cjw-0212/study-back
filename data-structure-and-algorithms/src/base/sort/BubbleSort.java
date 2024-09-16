package base.sort;

/**
 * @author CJW
 * @since 2024/7/19
 */
public class BubbleSort implements SortStrategy {
    /**
     * 冒泡排序
     * 每次将遍历区间内的最大数放到最后面，操作n-1轮后剩下的那个是最小值无需进行操作<br>
     * 时间复杂度O(n2)<br>
     * 空间复杂度O(1)
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        //外循环，遍历n-1次
        for (int i = 0; i < n - 1; i++) {
            //设置一个标志，如果在一轮遍历中一次交换都没有发生，说明当前已经排序完成了
            boolean swap = false;
            //内循环每次找到最大值将其放到最后
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //前者比后者大，进行交换
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //变更标志位
                    swap = true;
                }
            }
            if (!swap) {
                //无需再进行遍历
                break;
            }
        }
    }
}
