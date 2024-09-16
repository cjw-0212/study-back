package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/6
 */
public class LCR170 {
    public int reversePairs(int[] record) {
        int length = record.length;
        if (length < 2) {
            return 0;
        }
        //利用归并排序在并的时候计算逆序对的数量
        return divide(record, 0, record.length - 1);
    }

    private int divide(int[] num, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = divide(num, left, mid);
        int rightCount = divide(num, mid + 1, right);
        //如果左边的最大值都比右边的最小值还小，那就没有逆序对存在
        if (num[mid] <= num[mid + 1]) {
            return leftCount + rightCount;
        }
        int count = mergeAndCount(num, left, mid, right);
        return count + leftCount + rightCount;
    }

    private int mergeAndCount(int[] num, int left, int mid, int right) {
        int[] temp = new int[num.length];
        for (int i = left; i <= right; i++) {
            temp[i] = num[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                //左边没有数值了
                num[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                //右边没有数值了
                num[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                num[k] = temp[i];
                i++;
            } else {
                num[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}





















