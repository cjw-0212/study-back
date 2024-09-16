package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR163 {
    public int findKthNumber(int k) {
        //求解k所在数字的数位，此时k是从start开始计数的
        int digit = 1;
        long start = 1;
        long count = 9;
        while (k > count) {
            k -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        //确定所求数位所在的数字num
        long num = start + (k - 1) / digit;
        //确定所求数位在num中的哪一位数字
        String s = Long.toString(num);
        // 获得 num 的 第 (k - 1) % digit 个数位，并转化为 int
        return s.charAt((k - 1) % digit) - '0';
    }
}
