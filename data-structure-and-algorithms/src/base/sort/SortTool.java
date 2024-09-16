package base.sort;

/**
 * @author CJW
 * @since 2024/7/19
 */
public class SortTool {
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort(int[] nums) {
        sortStrategy.sort(nums);
    }
}
