package base.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author CJW
 * @since 2024/7/19
 */
public class Test {
    public static void main(String[] args) {
        int n=10000;
        int[] nums = new int[n];
        Random random=new Random();
        for (int i = 0; i < n; i++) {
            nums[i]=random.nextInt(n)+random.nextInt(n);
        }
        SortTool sortTool = new SortTool();
        //sortTool.setSortStrategy(new SelectSort());
        //sortTool.setSortStrategy(new BubbleSort());
        //sortTool.setSortStrategy(new InsertSort());
        //sortTool.setSortStrategy(new QuickSort());
        //sortTool.setSortStrategy(new MergeSort());
        //sortTool.setSortStrategy(new HeapSort());
        //sortTool.setSortStrategy(new CountSort());
        sortTool.setSortStrategy(new RadixSort());
        long startTime = System.currentTimeMillis();
        sortTool.sort(nums);
        long endTime=System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime);
    }
}
