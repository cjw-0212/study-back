package leetcode_hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2024/3/20
 */
public class P1 {
    public int[] twoSum(int[] nums, int target) {
        //利用哈希表将时间复杂度降低到n
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res=target-nums[i];
            if (map.containsKey(res)){
                return new int[]{i,map.get(res)};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}

























