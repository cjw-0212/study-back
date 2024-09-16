package base.search;

/**
 * @author CJW
 * @since 2024/7/25
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 45, 78, 90, 90, 90, 90, 90, 98, 100, 899, 900, 906, 10045, 35677, 99999};
        System.out.println(binarySearchRecursion(nums, 100));
    }

    /**
     * 二分查找，需要数据是从小到大有序的且不重复<br>
     * 二分查找需要跳跃访问，对于链表不太适合<br>
     * 对于小数据量，适用线性查找比二分查找效率高，因为线性查找只需执行一次判断，而二分查找需要加法出法等多次操作
     */
    private static int binarySort(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //取中点，向下取整，利用这种方式求中点可以避免大数越界
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找元素插入点，插入后保持有序性
     *
     * @param nums 无重复元素的数组
     */
    private static int binarySearchInsertNoRepeat(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        //没有找到相等元素，返回首个大于target的元素位置，即是target需要插入的位置
        return left;
    }

    /**
     * 寻找元素插入点，存在多个相等的要找到最左边的那个
     *
     * @param nums 有重复元素的数组
     */
    private static int binarySearchInsertRepeat(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //如果相等的话就吧right移动到mid-1处缩小范围，最后会指向第一个小于target的位置
                right = mid - 1;
            }
        }
        //left指向插入点
        return left;
    }

    /**
     * 查找最左一个target的位置
     */
    private static int binarySearchLeftEdge(int[] nums, int target) {
        int i = binarySearchInsertRepeat(nums, target);
        //数组中可能不存在该数值，就会发生返回索引越界或者返回的不是该值
        if (i == nums.length || nums[i] != target) {
            return -1;
        }
        return i;
    }

    /**
     * 查找最右一个target的位置
     */
    private static int binarySearchRightEdge(int[] nums, int target) {
        //转化为查找最做一个target+1的值然后将其减一就是target的最右位置
        int i = binarySearchInsertRepeat(nums, target + 1);
        int j = i - 1;
        if (j == -1 || nums[j] != target) {
            return -1;
        }
        return j;
    }

    /**
     * 二分查找递归方式实现
     */
    private static int binarySearchRecursion(int[] nums, int target) {
        return recursion(nums, 0, nums.length - 1, target);
    }

    private static int recursion(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] > target) {
            return recursion(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return recursion(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
