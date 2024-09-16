package base.sort;

/**
 * @author CJW
 * @since 2024/7/22
 */
public class InsertSort implements SortStrategy {
    /**
     * 它的工作原理与手动整理一副牌的过程非常相似。
     * 具体来说，我们在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置。<br>
     * 时间复杂度O(n2)<br>
     * 空间复杂度O(1)<br>
     * 在排序过程中相等元素的前后位置不会变化，每次插入会插入在相等元素的右侧
     *
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        //从第二位开始逐个拿出来进行插入排序
        for (int i = 1; i < n; i++) {
            //记录要进行插入的值
            int base = nums[i];
            //记录前一个的索引
            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                //继续向左侧遍历
                j--;
            }
            //将当前要排序的值放入正确的位置
            nums[j + 1] = base;
        }
    }
}
