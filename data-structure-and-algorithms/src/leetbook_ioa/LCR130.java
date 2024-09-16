package leetbook_ioa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CJW
 * @since 2024/8/2
 */
public class LCR130 {
    public int wardrobeFinishing1(int m, int n, int cnt) {
        if (cnt == 0) {
            return 1;
        }
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x >= m || y >= n || visit[x][y] || sums(x) + sums(y) > cnt) {
                continue;
            }
            visit[x][y] = true;
            ans++;
            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y + 1});
        }
        return ans;
    }

    public int wardrobeFinishing(int m, int n, int cnt) {
        if (cnt == 0) {
            return 1;
        }
        boolean[][] visit = new boolean[m][n];
        return dfs(0, 0, m, n, cnt, visit);
    }

    private static int dfs(int i, int j, int m, int n, int cnt, boolean[][] visit) {
        if (i >= m || j >= n || visit[i][j] || sums(i) + sums(j) > cnt) {
            return 0;
        }
        visit[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, cnt, visit) + dfs(i, j + 1, m, n, cnt, visit);
    }

    /**
     * 获取一个数的数位之和
     */
    private static int sums(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }
}
