package base.sort;

/**
 * @author CJW
 * @since 2024/7/24
 */
public class RadixSort implements SortStrategy{
    /**
     * 基数排序<br>
     * 解决计数排序遇到大范围数据导致占用过多内存空间的问题<br>
     * 基数排序利用数字各位之间的递进关系，依次对每一位进行排序，从而得到最终的排序结果。<br>
     * 但前提是数据必须可以表示为固定位数的格式，且位数不能过大。例如，浮点数不适合使用基数排序，因为其位数k过大
     * @param nums 待排序数组
     */
    @Override
    public void sort(int[] nums) {
        //获取数组最大值计算最大位数，这里只支持正数，如果有负数可以将所有值加上最小整数然后再进行操作
        int max=0;
        for (int num : nums) {
            if (num>max){
                max=num;
            }
        }
        //按照从低到高的遍历
        for (int exp=1;exp<max;exp*=10){
            sortDigit(nums,exp);
        }
    }

    /**
     * 获取数值的第k位<br>
     * exp=10的（k-1）次方
     */
    private static int digit(int num,int exp){
        //传入exp而不是k可以避免在此处进行重复的昂贵指数运算
        return (num/exp)%10;
    }

    /**
     * 根据第k位进行排序<br>
     * exp=10的（k-1）次方
     */
    private static void sortDigit(int[] nums,int exp){
        int[] count=new int[10];
        int n=nums.length;
        //统计出现次数
        for (int i = 0; i < n; i++) {
            //取该值的第k位
            int d=digit(nums[i],exp);
            count[d]++;
        }
        //求前缀和，将出现个数转化为数组索引
        for (int i = 0; i < count.length-1; i++) {
            count[i+1]+=count[i];
        }
        //倒序遍历，将元素填入临时数组
        int[] res=new int[n];
        for (int i=n-1;i>=0;i--){
            int d=digit(nums[i],exp);
            res[count[d]-1]=nums[i];
            count[d]--;
        }
        //将结果复制回原数组
        for (int i = 0; i < n; i++) {
            nums[i]=res[i];
        }
    }
}
