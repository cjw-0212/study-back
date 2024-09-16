package base.dynamic;

/**
 * @author CJW
 * @since 2024/7/29
 */
public class CompleteBag {
    public static void main(String[] args) {
        //完全背包问题，每个物品可以选择多次，求解一定容量下的最大价值
        int[] wgt = {10, 20, 30, 40, 50};
        int[] val = {50, 120, 150, 210, 240};
        int cap = 50;
        int result = getResultSpaceOptimize(wgt, val, cap);
        System.out.println(result);
    }

    private static int getResult(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                if (wgt[i - 1] > c) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    //这里与01背包问题不同，因为每个物品可以选择多次，所以选中时不需要进行i-1
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i][c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }

    private static int getResultSpaceOptimize(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        int[] dp = new int[cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                //零一背包的值由正上方和左上方的值转化而来，要采用倒序遍历，避免遍历到后边前面的值已经被覆盖
                //完全背包由于物品可选择多次，选中时状态转化和零一背包不同，其值由左边和正上方的值决定，所以需要正序遍历才能访问到最新值
                if (wgt[i - 1] <= c) {
                    dp[c] = Math.max(dp[c], dp[c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[cap];
    }
}
