package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/7/31
 */
public class LCR121 {
    public static void main(String[] args) {
        int[][] plants = {
                 {2,3,6,8},
                 {4,5,8,9},
                 {5,9,10,12}
        };
        int target = 11;
        System.out.println(findTargetIn2DPlants(plants, target));
    }

    public static boolean findTargetIn2DPlants(int[][] plants, int target) {
        if (plants.length == 0) {
            return false;
        }
        //对于每一个位置，其左边的一定比它小，其下边的一定比它大
        //0，3 0，2 1，3
        //1，2 1，1 2，2
        //从左上角元素开始
        int i = 0;
        int j = plants[0].length - 1;
        while (i < plants.length && j >= 0) {
            if (plants[i][j] > target) {
                //座左移一行
                j--;
            } else if (plants[i][j] < target) {
                //往下移动一行
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
