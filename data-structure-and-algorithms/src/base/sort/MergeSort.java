package base.sort;

/**
 * @author CJW
 * @since 2024/7/23
 */
public class MergeSort implements SortStrategy {
    /**
     * 归并排序<br>
     * 划分阶段：通过递归不断地将数组从中点处分开，将长数组的排序问题转换为短数组的排序问题。<br>
     * 合并阶段：当子数组长度为 1 时终止划分，开始合并，持续地将左右两个较短的有序数组合并为一个较长的有序数组，直至结束。<br>
     * 时间复杂度O(nlogn)<br>
     * 空间复杂度O(n)
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序递归
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //划分阶段
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        //合并阶段，与树的后序遍历一样的道理
        merge(nums, left, mid, right);
    }

    /**
     * 合并左右子数组
     *
     * @param left  数组左端点
     * @param mid   数组重点
     * @param right 数组右端点
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        //记录左右子数组的起点
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        //将子数组剩余的数值也放入临时数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        //将临时数组的元素放入原数组的对应位置
        for (k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }
}
