package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/2
 */
public class LCR132 {
    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len <= 3) {
            return bamboo_len - 1;
        }
        int b = bamboo_len % 3;
        int p = 1000000007;
        long rem = 1;
        long x = 3;
        //这里留出一个三来后续对b进行处理需要用到
        for (int a = bamboo_len / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if (b == 0) {
            return (int) ((rem * 3) % p);
        }
        if (b == 1) {
            return (int) ((rem * 2 * 2) % p);
        }
        return (int) ((rem * 3 * 2) % p);
    }


    //(a+b)%c=(a%c+b%c)%c
    //a%c=a%c%c
    //(a*b)%c=((a%c)*(b%c))%c

    /**
     * 循环求余数x的a次方
     */
    private static int getResult1(int x, int a) {
        int ans = 1;
        int p = 1000000007;
        for (int i = 0; i < a; i++) {
            //根据公式三
            ans = (ans * x) % p;
        }
        return ans;
    }

    /**
     * 快速幂求余数 二分求余
     */
    private static int getResult2(int x, int a) {
        //这里要使用long，因为最大可能会达到p*p的量级，需要long才可以
        long ans = 1;
        long b = x;
        int p = 1000000007;
        //i/2相当于a>>=1
        for (int i = a; i > 0; i /= 2) {
            //这一步相当于a&1==1
            if (i % 2 == 1) {
                ans = (ans * b) % p;
            }
            b = (b * b) % p;
        }
        return (int) ans;
    }

    private static int fastPow(int x, int a) {
        long ans = 1;
        long b = x;
        int p = 1000000007;
        while (a != 0) {
            if ((a & 1) == 1) {
                ans = (ans * b) % p;
            }
            b = (b * b) % p;
            a >>= 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(fastPow(2, 10));
    }
}
