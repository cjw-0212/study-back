package base.dynamic;

/**
 * @author CJW
 * @since 2024/7/30
 */
public class MoneyChangeB {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 5;
        System.out.println(getResult(coins, target));
    }

    /**
     * 硬币可以重复选择，求解组成目标值的方案数量
     */
    private static int getResult(int[] coins, int target) {
        int n = coins.length;
        //表示前i个硬币可以凑出总和为j的组合数量
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                if (coins[i - 1] <= sum) {
                    dp[sum]=dp[sum]+dp[sum-coins[i-1]];
                }
            }
        }
        return dp[target];
    }
}
