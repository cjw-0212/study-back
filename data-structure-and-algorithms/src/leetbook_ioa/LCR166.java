package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR166 {
    public int jewelleryValue(int[][] frame) {
        int n = frame.length;
        int m = frame[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                dp[i][j] += frame[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
