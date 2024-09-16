package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/1
 */
public class LCR127 {
    public static void main(String[] args) {
        System.out.println(trainWays(0));
    }

    public static int trainWays(int num) {
        if (num == 0) {
            return 1;
        }
        if (num < 3) {
            return num;
        }
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[num];
    }
}
