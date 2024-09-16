package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/1
 */
public class LCR128 {
    /**
     * 寻找旋转排序数组的最小值
     */
    public int stockManagement(int[] stock) {
        int left = 0;
        int right = stock.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (stock[mid] > stock[right]) {
                //此中点位于最小值的的左侧，可以排除左边数据
                //由于大于右端点，可以认定肯定不会为最小值，可以mid+1将该中点跳过
                left = mid + 1;
            } else if (stock[mid] < stock[right]) {
                //此中点位于最小值的右侧，可以排序右边数据
                //[3,1,3]，不能mid-1，否则会忽略掉可能为最小值的mid
                right = mid;
            } else {
                //由于存在相等元素，此时只能排除该右端点
                right--;
            }
        }
        return stock[left];
    }
}
