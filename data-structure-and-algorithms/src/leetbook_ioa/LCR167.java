package leetbook_ioa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR167 {
    public int dismantlingAction(String arr) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int l = -1;
        for (int r = 0; r < arr.length(); r++) {
            if (map.containsKey(arr.charAt(r))) {
                //取最大值，保证区间内没有重复字符
                l = Math.max(l, map.get(arr.charAt(r)));
            }
            map.put(arr.charAt(r), r);
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
