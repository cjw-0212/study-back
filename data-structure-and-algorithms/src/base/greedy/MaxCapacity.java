package base.greedy;

/**
 * @author CJW
 * @since 2024/7/31
 */
public class MaxCapacity {
    public static void main(String[] args) {
        //请在数组中选择两个隔板，使得组成的容器的容量最大，返回最大容量。
        int[] board = {3, 8, 5, 2, 7, 7, 3, 4};
        System.out.println(getResult(board));
    }

    private static int getResult(int[] board) {
        //初始化指针指向两边
        int left = 0;
        int right = board.length - 1;
        //每次把短板子向内移动，并更新最大容量
        //向内移动长板，高度不变或者变小，底部距离变小，所以容量肯定变小
        //向内移动短板，底部距离变短，但是可能遇到更长的板子高度变长，容量变大
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(board[left], board[right]) * (right - left));
            if (board[left] < board[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
