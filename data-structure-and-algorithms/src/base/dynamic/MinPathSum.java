package base.dynamic;

/**
 * @author CJW
 * @since 2024/7/29
 */
public class MinPathSum {
    public static void main(String[] args) {
        //从左上角开始，每次只能向下或者向右移动一格，每格的数值就是代价，求解走到右下角的最小代价
        int[][] grip = {
                {1, 3, 1, 5},
                {2, 2, 4, 2},
                {5, 3, 2, 1},
                {4, 3, 5, 2},
        };
        System.out.println(minPathSumDpSpaceOptimize(grip));
    }

    private static int minPathSumDp(int[][] grip) {
        int n = grip.length;
        int m = grip[0].length;
        //定义一个dp二维数组用来记录走到第i行第j列所需要的代价是多少
        int[][] dp = new int[n][m];
        //初始化临界条件值
        dp[0][0] = grip[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grip[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grip[0][j];
        }
        //遍历其余的行和列
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //状态转移公式
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grip[i][j];
            }
        }
        //返回到达右下角的最小代价
        return dp[n - 1][m - 1];
    }

    private static int minPathSumDpSpaceOptimize(int[][] grip) {
        int n = grip.length;
        int m = grip[0].length;
        //由于每个格子的状态只与左一个格子和上一个格子有关系，可以使用一个一维数组来记录
        int[] dp = new int[m];
        //初始化临界值
        dp[0] = grip[0][0];
        //初始化首行的值
        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + grip[0][j];
        }
        //对下面的行进行状态转移
        for (int i = 1; i < n; i++) {
            dp[0] = dp[0] + grip[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grip[i][j];
            }
        }
        return dp[m - 1];
    }
}

















