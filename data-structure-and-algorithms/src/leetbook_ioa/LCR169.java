package leetbook_ioa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR169 {
    public char dismantlingAction(String arr) {
        //遍历字符串使用map保存字符是否重复出现
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = arr.toCharArray();
        for (char ch : chars) {
            map.put(ch, !map.containsKey(ch));
        }
        for (char ch : chars) {
            if (map.get(ch)) {
                return ch;
            }
        }
        return ' ';
    }
}
