package leetcode_hot_100;

/**
 * @author CJW
 * @since 2024/3/24
 */
public class P11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        //判断中间是否还有数据
        while (left < right) {
           int newMax=(right-left)*Math.min(height[left],height[right]);
           if (newMax>max){
               max=newMax;
           }
           if (height[left]<=height[right]){
               int tempLeft=height[left];
               while (left<right&&height[left]<=tempLeft){
                   left++;
               }
           }else {
               int tempRight=height[right];
               while (left<right&&height[right]<=tempRight){
                   right--;
               }
           }
        }
        return max;
    }
}
