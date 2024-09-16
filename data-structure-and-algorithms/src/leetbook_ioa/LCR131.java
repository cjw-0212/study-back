package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/2
 */
public class LCR131 {
    public int cuttingBamboo(int bamboo_len) {
        //小于等于三的返回
        if (bamboo_len<=3){
            return bamboo_len-1;
        }
        int a = bamboo_len / 3;
        int b = bamboo_len % 3;
        if (b == 2) {
            //剩一个2返回
            return (int) (Math.pow(3, a) * 2);
        }
        if (b==1){
            //剩一个1，需要拿出一个3凑成2*2>3*1
            return (int) (Math.pow(3,a-1)*2*2);
        }
        //整除
        return (int) Math.pow(3,a);
    }
}
