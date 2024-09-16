package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/12
 */
public class LCR146 {
    public int[] spiralArray(int[][] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int top = 0;
        int button = array.length - 1;
        int left = 0;
        int right = array[0].length - 1;
        int[] ans = new int[array.length * array[0].length];
        int k = 0;
        //依次循环
        while (true) {
            //从左往右
            for (int i = left; i <= right; i++) {
                ans[k++] = array[top][i];
            }
            if (++top > button) {
                break;
            }
            //从上往下
            for (int i = top; i <= button; i++) {
                ans[k++] = array[i][right];
            }
            if (--right < left) {
                break;
            }
            //从右往左
            for (int i = right; i >= left; i--) {
                ans[k++] = array[button][i];
            }
            if (--button < top) {
                break;
            }
            //从下往上
            for (int i = button; i >= top; i--) {
                ans[k++] = array[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
