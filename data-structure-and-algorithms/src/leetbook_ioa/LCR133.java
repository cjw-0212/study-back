package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/7
 */
public class LCR133 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(3));
    }
    private static int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                num++;
            }
            n >>>= 1;
        }
        return num;
    }
}
