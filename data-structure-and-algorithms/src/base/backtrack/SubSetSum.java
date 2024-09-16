package base.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/26
 */
public class SubSetSum {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 3};
        List<List<Integer>> res = subSetSumPerfectRepeat(nums, 9);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
        System.out.println(res.size());
    }

    private static List<List<Integer>> subSetSumSimple(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        solveSubSetSumSimple(new ArrayList<>(n), target, 0, nums, res);
        return res;
    }

    /**
     * 每个元素可以被选中多次<br>
     * 不同顺序的相同元素算是重复组合<br>
     * 这种方式存在重复组合，元素先后选取顺序会导致重复组合出现
     *
     * @param state   记录被选中的数字
     * @param target  目标总和
     * @param total   选中数字合
     * @param choices 可以被选择的数字（无重复元素）
     * @param res     存储结果集
     */
    private static void solveSubSetSumSimple(List<Integer> state, int target, int total, int[] choices, List<List<Integer>> res) {
        if (target == total) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        //遍历选择数值
        for (int choice : choices) {
            //如果超过目标值就跳过
            if (total + choice > target) {
                continue;
            }
            state.add(choice);
            solveSubSetSumSimple(state, target, total + choice, choices, res);
            //回溯
            state.remove(state.size() - 1);
        }
    }

    private static List<List<Integer>> subSetSumPerfect(int[] nums, int target) {
        int n = nums.length;
        //先将数组按照从小到大进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solveSubSetSumPerfect(new ArrayList<>(n), target, nums, 0, res);
        return res;
    }

    /**
     * 可以排除重复组合
     *
     * @param state   记录被选中的数字
     * @param target  目标总和
     * @param choices 可选择的元素（无重复元素）
     * @param start   遍历元素的起始点
     * @param res     记录结果集
     */
    private static void solveSubSetSumPerfect(List<Integer> state, int target, int[] choices, int start,
                                              List<List<Integer>> res) {
        //使用target减去元素值的方式进行计算，可以省去total变量，当target为0时表示找到符合要求的集合了
        if (target == 0) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        //从start位置开始遍历，避免生成重复元素
        for (int i = start; i < choices.length; i++) {
            if (target - choices[i] < 0) {
                //前提是数组已经是从小到大排好序了，后面的元素更大，所以到这一步就可以直接跳出了
                break;
            }
            state.add(choices[i]);
            //继续寻找下一个，此时需要更新遍历起始索引的位置
            solveSubSetSumPerfect(state, target - choices[i], choices, i, res);
            //回溯
            state.remove(state.size() - 1);
        }
    }

    private static List<List<Integer>> subSetSumPerfectRepeat(int[] nums, int target) {
        int n = nums.length;
        //先将数组按照从小到大进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        solveSubSetSumPerfectRepeat(new ArrayList<>(n), target, nums, 0, res);
        return res;
    }

    /**
     * 这里每个数字只能选择一次
     *
     * @param choices 含有重复元素的可选择数组
     */
    private static void solveSubSetSumPerfectRepeat(List<Integer> state, int target, int[] choices, int start,
                                                    List<List<Integer>> res) {
        //使用target减去元素值的方式进行计算，可以省去total变量，当target为0时表示找到符合要求的集合了
        if (target == 0) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        //从start位置开始遍历，避免生成重复元素
        for (int i = start; i < choices.length; i++) {
            if (target - choices[i] < 0) {
                //前提是数组已经是从小到大排好序了，后面的元素更大，所以到这一步就可以直接跳出了
                break;
            }
            //再次进行剪枝，对于数组中存在的相同元素，每轮只允许选中其中一个，由于数组已经排序好，对于下一个一样的则直接跳过
            if (i > start && choices[i] == choices[i - 1]) {
                //直接跳过，然后对i+1之后的进行遍历，这样既可以跳过重复元素，也可以避免重复选择同一个元素
                continue;
            }
            state.add(choices[i]);
            //继续寻找下一个，此时需要更新遍历起始索引的位置
            solveSubSetSumPerfectRepeat(state, target - choices[i], choices, i + 1, res);
            //回溯
            state.remove(state.size() - 1);
        }
    }
}
