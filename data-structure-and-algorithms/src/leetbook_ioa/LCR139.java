package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/8
 */
public class LCR139 {
    //双指针左边过滤奇数右边过滤偶数，然后左右交换
    public int[] trainingPlan(int[] actions) {
        int left = 0;
        int right = actions.length - 1;
        while (left < right) {
            while (left < right && (actions[left] & 1) == 1) {
                left++;
            }
            while (left < right && (actions[right] & 1) == 0) {
                right--;
            }
            int temp=actions[left];
            actions[left]=actions[right];
            actions[right]=temp;
        }
        return actions;
    }
}
