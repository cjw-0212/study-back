package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/1
 */
public class LCR126 {
    public static void main(String[] args) {
        System.out.println(fib2(45));
    }
    /**
     * 使用递归，会产生很多重复计算
     */
    public static int fib1(int n) {
        if (n==0||n==1){
            return n;
        }
        return fib1(n-1)+fib1(n-2);
    }

    /**
     * 动态规划，由于状态转移方程只有三个数有关，为了节省空间可以将dp[n]的数组替换成三个变量
     */
    public static int fib2(int n){
        int mod=1000000007;
        if (n==0||n==1){
            return n;
        }
        int a=0;
        int b=1;
        int sum = 0;
        for (int i=1;i<n;i++){
            sum=(a+b)%mod;
            a=b;
            b=sum;
        }
        return sum;
    }
}
