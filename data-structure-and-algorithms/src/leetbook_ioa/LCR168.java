package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR168 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int n1 = res[a] * 2;
            int n2 = res[b] * 3;
            int n3 = res[c] * 5;
            res[i] = Math.min(n1, Math.min(n2, n3));
            if (n1 == res[i]) {
                a++;
            }
            if (n2 == res[i]) {
                b++;
            }
            if (n3 == res[i]) {
                c++;
            }
        }
        return res[n - 1];
    }
}
