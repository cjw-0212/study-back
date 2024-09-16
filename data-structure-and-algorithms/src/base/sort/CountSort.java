package base.sort;

/**
 * @author CJW
 * @since 2024/7/24
 */
public class CountSort implements SortStrategy {
    /**
     * 计数排序通过统计元素数量来实现排序，通常应用于整数数组。
     * 适用于非负整数，数据量大但是数据范围小的数组集
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        //统计最大数值，设置一个计数数组
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        //统计数字出现次数
        for (int num : nums) {
            count[num]++;
        }
        //计算计数数组的的前缀和，表示指定元素在数组中的最后一个位置
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }
        //倒序遍历将元素逐个放入指定索引处
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            res[count[num] - 1] = num;
            count[num]--;
        }
        //将数组复制到nums中
        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }
}
