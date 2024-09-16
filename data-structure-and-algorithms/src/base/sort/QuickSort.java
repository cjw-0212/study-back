package base.sort;

/**
 * @author CJW
 * @since 2024/7/23
 */
public class QuickSort implements SortStrategy {
    /**
     * 快速排序<br>
     * 选择数组中的某个元素作为“基准数”，将所有小于基准数的元素移到其左侧，而大于基准数的元素移到其右侧。然后再递归对分出来的子数组重复以上操作
     * 知道无法再分出子数组<br>
     * 左子数组任意元素<=基准数<=右子数组任意元素<br>
     * 时间复杂度O(nlogn)<br>
     * 空间复杂度O(n)
     *
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序递归方法
     *
     * @param nums  待排序数组
     * @param left  左端点
     * @param right 右端点
     */
    private static void quickSort(int[] nums, int left, int right) {
        //子数组长度为1终止递归
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        //递归左右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /**
     * 子数组区间划分
     *
     * @param nums  待排序数组
     * @param left  左端点
     * @param right 右端点
     * @return 左右子数组的间隔位置
     */
    private static int partition(int[] nums, int left, int right) {
        //基准数优化，选择三个数的中位数并将其换到首位
        int base = randomBase(nums, left, (left + right) / 2, right);
        swap(nums, left, base);
        //以最左边的值作为基准数
        int i = left, j = right;
        while (i < j) {
            //从右向左找第一个比基准数小的值
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            //从左向右找第一个比基准数大的值
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            //将找到的两个值进行交换
            swap(nums, i, j);
        }
        //将基准点交换到两个子数组的中间位置
        swap(nums, left, i);
        return i;
    }

    /**
     * 交换元素
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 获取三个数的中位数作为新的基准数
     */
    private static int randomBase(int[] nums, int left, int mid, int right) {
        int l = nums[left], m = nums[mid], r = nums[right];
        if ((l <= m && m <= r) || (r <= m && m <= l)) {
            return mid;
        }
        if ((l <= r && r <= m) || (m <= r && r <= l)) {
            return right;
        }
        return left;
    }
}
