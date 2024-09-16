package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/22
 */
public class LCR161 {
    public int maxSales(int[] sales) {
        //对于以第i个位置为结尾的连续最大和是多少
        int pre = sales[0];
        int max = sales[0];
        for (int i = 1; i < sales.length; i++) {
            pre=Math.max(sales[i],pre+sales[i]);
            max=Math.max(max,pre);
        }
        return max;
    }
}
