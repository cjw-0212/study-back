package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/7
 */
public class LCR134 {
    public double myPow(double x, int n) {
        int a;
        if (n>0){
            a=n;
        }else {
            a=-n;
        }
        double ans=1;
        double base=x;
        while (a!=0){
            if ((a&1)==1){
                ans*=base;
            }
            base*=base;
            a>>>=1;
        }
        if (n>0){
            return ans;
        }else {
            return 1/ans;
        }
    }
}
