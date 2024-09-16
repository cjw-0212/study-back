package leetbook_ioa;

import java.util.Arrays;

/**
 * @author CJW
 * @since 2024/8/16
 */
public class LCR159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        //返回最小的cnt个数
        quickSort(stock, 0, stock.length - 1, cnt);
        return Arrays.copyOfRange(stock, 0, cnt);
    }

    private void quickSort(int[] nums, int left, int right, int cnt) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        //选择递归左右子数组
        if (pivot > cnt) {
            //证明第cnt+1个小的数字在右边
            quickSort(nums, left, pivot - 1, cnt);
        } else if (pivot < cnt) {
            //证明第cnt+1小的数字在左边
            quickSort(nums, pivot + 1, right, cnt);
        }
        //相等证明第cnt+1个小的数字就在此位置，前cnt个小的数已到位无需再继续进行此柜
    }

    /**
     * 以基准数为中介划分左右子数组，返回中介点的索引
     */
    private int partition(int[] nums, int left, int right) {
        int base = randomBase(nums, left, left + (right - left) / 2, right);
        swap(nums, left, base);
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        //将基准数交换到中间
        swap(nums, i, left);
        return i;
    }

    /**
     * 获取三者中的中位数作为基准数
     */
    private int randomBase(int[] nums, int left, int mid, int right) {
        int l = nums[left], m = nums[mid], r = nums[right];
        if ((l <= m && m <= r) || (r <= m && m <= l)) {
            return mid;
        } else if ((m <= l && l <= r) || (r <= l && l <= m)) {
            return left;
        } else {
            return right;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
