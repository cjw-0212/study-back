package base.dynamic;

import java.util.Arrays;

/**
 * @author CJW
 * @since 2024/7/29
 */
public class ZeroOneBag {
    public static void main(String[] args) {
        //零一背包问题，每个物品只能选择一次，问在限定背包容量下能放入物品的最大价值。
        int[] wgt = {1, 2, 3};
        int[] val = {5, 11, 15};
        int cap = 4;
        int result = getResultSpaceOptimize(wgt, val, cap);
        System.out.println(result);
    }

    /**
     * @param wgt 物品占用空间数组（第i个物品对应i-1的位置）
     * @param val 物品价值数组
     * @param cap 容量
     * @return 能得到的最大价值
     */
    private static int getResult(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        //初始化dp表，dp[i][j]表示前i个物品在容量为j的背包下可以得到的最大价值
        //在物品数量为0或容量为0的情况下价值为0，与数组的初始化状态0一致
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= cap; c++) {
                //超过总容量不加入
                if (wgt[i - 1] > c) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    int yse = dp[i - 1][c - wgt[i - 1]] + val[i - 1];
                    int no = dp[i - 1][c];
                    dp[i][c] = Math.max(yse, no);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n][cap];
    }

    private static int getResultSpaceOptimize(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        //由于每个格子都是由其正上方的和左上方的格子转换来的，所以可以使用一个一纬数组来表示
        int[] dp = new int[cap + 1];
        for (int i = 1; i <= n; i++) {
            //由于从前往后遍历上一轮的数据可能会被覆盖，所以这里采从后往前遍历避免数据覆盖
            for (int c = cap; c >= 1; c--) {
                if (wgt[i - 1] <= c) {
                    dp[c] = Math.max(dp[c], dp[c - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[cap];
    }
}
