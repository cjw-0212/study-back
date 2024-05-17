package leetcode_hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CJW
 * @since 2024/3/28
 */
public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //顺序排列大于零后边没有匹配的解
            if (nums[i]>0){
                return ans;
            }
            //顺序排列的同时要跳过重复元素避免产生重复解
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while (right>left){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    //去除重复值避免产生相同答案
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    //同时移动两边
                    left++;
                    right--;
                } else if (sum<0) {
                    //跳过重复元素
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                }else {
                    //跳过重复元素
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                }
            }
        }
        return ans;
    }
}
