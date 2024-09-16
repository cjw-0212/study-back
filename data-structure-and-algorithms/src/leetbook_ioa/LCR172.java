package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/11
 */
public class LCR172 {
    public int countTarget(int[] scores, int target) {
        int count = 0;
        for (int score : scores) {
            if (score > target) {
                break;
            }
            if (target == score) {
                count++;
            }
        }
        return count;
    }
}
