package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/7
 */
public class LCR135 {
    public int[] countNumbers(int cnt) {
        int max = (int) (Math.pow(10, cnt) - 1);
        int[] num = new int[max];
        for (int i = 0; i < max; i++) {
            num[i] = i + 1;
        }
        return num;
    }
}
