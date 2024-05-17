package leetcode_hot_100;

import java.util.*;

/**
 * @author CJW
 * @since 2024/3/21
 */
public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            //返回映射值，没有就返回默认值
           List<String> list=map.getOrDefault(key,new ArrayList<>());
           list.add(str);
           map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
