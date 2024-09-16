package base.sort;

/**
 * @author CJW
 * @since 2024/7/19
 */
public class SelectSort implements SortStrategy{
    /**
     * 选择排序
     * 每次从未排序的区间查找一个最小的值，将其放到已排序区间的末尾<br>
     * 时间复杂度O(n2)<br>
     * 空间复杂度O(1)
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        int n=nums.length;
        //循环n-1次将前n-1个排好，此时最后一个是最大值无需进行操作
        for (int i=0;i<n-1;i++){
            //使用k记录未排序区间最小值索引
            int k=i;
            //遍历未排序的所有元素
            for(int j=i+1;j<n;j++){
                if (nums[k]>nums[j]){
                    //遇到更小的记录索引
                    k=j;
                }
            }
            //将最小元素与未排序区间的收个元素交换
            int temp=nums[i];
            nums[i]=nums[k];
            nums[k]=temp;
        }
    }
}
