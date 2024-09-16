package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/7
 */
public class LCR137 {
    public boolean articleMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //表示前s的前i个字符与p的前j个字符是否匹配
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    //判断s的当前字符是否与*的前一个字符相等
                    if (matches(s, p, i, j - 1)) {
                        //将*号与前一个字符匹配s的一个字符并继续匹配其他字符或者一个字符都不匹配
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 判断s的第i个字符和p的第j个字符是否相等
     */
    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
