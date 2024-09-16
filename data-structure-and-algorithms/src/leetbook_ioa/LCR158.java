package leetbook_ioa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2024/8/16
 */
public class LCR158 {
    public static void main(String[] args) {
        int[] num = {6, 1, 3, 1, 1, 1};
        int i = inventoryManagement(num);
    }

    private static int inventoryManagement(int[] stock) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : stock) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > stock.length / 2) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    /**
     * 摩尔投票法<br>
     * 假设第一个数为众数，遍历数组，若相等则投票数加一，若不相等则投票数减一<br>
     * 当投票数为0时就假设下一个数为众数（前面总和为零的剔除掉了）
     */
    private static int inventoryManagement2(int[] stock) {
        int x=0;
        int votes = 0;
        for (int i : stock) {
            if (votes == 0) {
                x = i;
            }
            if (x==i){
                votes++;
            }else {
                votes--;
            }
        }
        return x;
    }
}
