package base.dynamic;

import java.util.Arrays;

/**
 * @author CJW
 * @since 2024/7/30
 */
public class StringEditNum {
    public static void main(String[] args) {
        String s1 = "bag";
        String s2 = "pack";
        System.out.println(getResult(s1, s2));
    }

    private static int getResult(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        //表示将s1的前i个字符转变成s2的前j的字符需要的最少编辑次数
        int[][] dp = new int[n1 + 1][n2 + 1];
        //初始化，一个长度为0一个长度为不等于0的n，则编辑步骤为n
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //两个字符相等
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //存在添加，删除，替换三种状态，选择编辑次数最小的状态然后加上1就是当前的编辑次数
                    //在s1添加
                    int add = dp[i][j - 1];
                    //在s1删除
                    int del = dp[i - 1][j];
                    //在s1替换
                    int rpl = dp[i - 1][j - 1];
                    dp[i][j] = min(add, del, rpl) + 1;
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[n1][n2];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
