package base.dynamic;

import java.util.Arrays;

/**
 * @author CJW
 * @since 2024/7/30
 */
public class MoneyChangeA {
    public static void main(String[] args) {
        //对应硬币的面值
        int[] coins = {1, 2, 5};
        //目标金额
        int target = 4;
        System.out.println(getResultSpaceOptimize(coins, target));
    }

    /**
     * 每个硬币可以重复选择，求解刚好达到金额的最小硬币数量
     */
    private static int getResult(int[] coins, int target) {
        int n = coins.length;
        //dp[i][j]表示对于前i个物品，总额为j时需要的最小硬币数量
        int[][] dp = new int[n + 1][target + 1];
        //初始化，使用target+1来填充无效解
        int max = target + 1;
        for (int i = 0; i <=target; i++) {
            //当硬币种类为0时，没有解
            dp[0][i] = max;
        }
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                if (coins[i-1]>sum){
                    //不加入
                    dp[i][sum]=dp[i-1][sum];
                }else {
                    dp[i][sum]=Math.min(dp[i-1][sum],dp[i][sum-coins[i-1]]+1);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n][target]!=max?dp[n][target]:-1;
    }

    private static int getResultSpaceOptimize(int[] coins, int target) {
        int n = coins.length;
        int[] dp=new int[target+1];
        //初始化
        Arrays.fill(dp,target+1);
        dp[0]=0;
        for (int i=1;i<=n;i++){
            for (int sum=1;sum<=target;sum++){
                if (coins[i-1]<=sum){
                    dp[sum]=Math.min(dp[sum],dp[sum-coins[i-1]]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target]!=target+1?dp[target]:-1;
    }
}
