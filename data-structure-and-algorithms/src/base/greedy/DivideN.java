package base.greedy;

/**
 * @author CJW
 * @since 2024/7/31
 */
public class DivideN {
    public static void main(String[] args) {
        //给定一个正整数n,将其切分为至少两个正整数的和，求切分后所有整数的乘积最大是多少
        System.out.println(getResult(10));
    }

    private static int getResult(int n) {
        if (n<=3){
            return n-1;
        }
        //3的个数
        int a = n / 3;
        //余数
        int b = n % 3;
        if (b == 2) {
            //余数为2，返回成绩
            return (int) (Math.pow(3, a) * 2);
        }
        if (b == 1) {
            //余数为1，将最后一个3和它凑起来变成2*2
            return (int) (Math.pow(3, a - 1) * 2 * 2);
        }
        //余数为0直接返回
        return (int) Math.pow(3, a);
    }
}
