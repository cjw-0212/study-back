package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR165 {
    public int crackNumber(int ciphertext) {
        String str = String.valueOf(ciphertext);
        //动态规划（每个数代表由前几个字符的可能性），由于只与前两项有关，使用滚动数组降低空间复杂度
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < str.length(); i++) {
            //滚动数组
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("10") >= 0 && pre.compareTo("25") <= 0) {
                r += p;
            }
        }
        return r;
    }
}
