package leetcode_hot_100;

/**
 * @author CJW
 * @since 2024/3/24
 */
public class P283 {
    public void moveZeroes1(int[] nums) {
        //找到一个非零的数，与前面最靠前的0交换
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=0){
                int j=i;
                while (j-1>=0&&nums[j-1]==0){
                    j--;
                }
               if (j!=i){
                   nums[j]=nums[i];
                   nums[i]=0;
               }
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        //双指针，将不为零的数字全放在left之前，left和right之间全是零
       int left=0,right=0,len=nums.length;
       while (right<len){
           if (nums[right]!=0){
               int temp=nums[left];
               nums[left]=nums[right];
               nums[right]=temp;
               left++;
           }
           right++;
       }
    }
}
