package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/22
 */
public class LCR162 {
    public int digitOneInNumber(int num) {
        int digit = 1;
        int res = 0;
        int high = num / 10;
        int low = 0;
        int cur = num % 10;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += (high)*digit;
            } else if (cur == 1) {
                res+=(high*digit+low+1);
            } else {
                res += ((high + 1) * digit);
            }
            low += (cur * digit);
            digit *= 10;
            cur = high / 10;
            high = high % 10;
        }
        return res;
    }
}
