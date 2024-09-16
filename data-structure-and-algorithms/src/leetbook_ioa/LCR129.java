package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/1
 */
public class LCR129 {
    public static void main(String[] args) {
        char[][] grip = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String target = "SEE";
        System.out.println(wordPuzzle(grip, target));
    }

    public static boolean wordPuzzle(char[][] grid, String target) {
        //以每个字符为起点进行寻找
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (recursion(grid, target.toCharArray(), i, j, 0)) {
                    return true;
                }
            }
        }
        //找不到
        return false;
    }

    /**
     * @param k 当前匹配到的target的位置
     */
    private static boolean recursion(char[][] grip, char[] target, int i, int j, int k) {
        //索引越界或者当前元素与目标字符不同
        if (i < 0 || i >= grip.length || j < 0 || j >= grip[0].length || grip[i][j] != target[k]) {
            return false;
        }
        if (k == target.length - 1) {
            //找到全部字符
            return true;
        }
        //字符匹配但是未找到全部字符
        //将字符置空
        grip[i][j] = ' ';
        //向四个方向寻找
        boolean res = recursion(grip, target, i + 1, j, k + 1)
                || recursion(grip, target, i - 1, j, k + 1)
                || recursion(grip, target, i, j + 1, k + 1)
                || recursion(grip, target, i, j - 1, k + 1);
        //回溯字符
        grip[i][j] = target[k];
        return res;
    }
}
