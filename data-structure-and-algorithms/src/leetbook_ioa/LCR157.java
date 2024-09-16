package leetbook_ioa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author CJW
 * @since 2024/8/15
 */
public class LCR157 {
    private char[] chars;
    private List<String> ans;

    /**
     * 全排列，不含重复元素
     */
    public String[] goodsOrder(String goods) {
        chars = goods.toCharArray();
        ans = new ArrayList<>();
        recur(0);
        return ans.toArray(new String[0]);
    }

    /**
     * @param x 当前要处理的索引位置
     */
    private void recur(int x) {
        //最后一个只有一种选择不用进行操作，添加结果
        if (x == chars.length - 1) {
            ans.add(new String(chars));
            return;
        }
        //利用一个hashset进行去重对于当前位置，相同的字符只能被选择一次
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            //先记录元素再交换
            set.add(chars[i]);
            swap(x, i);
            //往后寻找下一位
            recur(x + 1);
            //回溯
            swap(x, i);
        }
    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
