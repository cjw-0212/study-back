package base.backtrack;

import java.util.*;

/**
 * @author CJW
 * @since 2024/7/26
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums={1,2,3,3};
        List<List<Integer>> res = permutationRepeat(nums);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
        System.out.println(res.size());
    }

    private static List<List<Integer>> permutationNoRepeat(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        solvePermutationNoRepeat(new ArrayList<>(n), nums, new boolean[n], res);
        return res;
    }

    private static List<List<Integer>> permutationRepeat(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        solvePermutationRepeat(new ArrayList<>(n), nums, new boolean[n], res);
        return res;
    }

    /**
     * 全排列
     *
     * @param state    记录已经被选中的数字排列
     * @param choices   没有重复元素的数组
     * @param selected 标记当前索引位置的数值是否已经被state选中
     * @param res      存储全排列的结果
     */
    private static void solvePermutationNoRepeat(List<Integer> state, int[] choices, boolean[] selected,
                                                 List<List<Integer>> res) {
        if (state.size() == choices.length) {
            //记录个数等于可选择元素个数，排列完成
            //这里要复制元素创建一个新数组，否则会被回溯掉
            res.add(new ArrayList<Integer>(state));
            return;
        }
        for (int i = 0; i < choices.length; i++) {
            //判单是否已经被选中
            if (!selected[i]) {
                state.add(choices[i]);
                selected[i] = true;
                //继续选择
                solvePermutationNoRepeat(state, choices, selected, res);
                //回溯
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    private static void solvePermutationRepeat(List<Integer> state, int[] choices, boolean[] selected,
                                                 List<List<Integer>> res) {
        if (state.size() == choices.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        //在每一轮的选择中都加入一个哈希集合确保本论选择内重复元素只被选择一次
        Set<Integer> duplicate=new HashSet<>();
        for (int i = 0; i < choices.length; i++) {
            //判单是否已经被选中
            if (!selected[i]&&!duplicate.contains(choices[i])) {
                state.add(choices[i]);
                selected[i] = true;
                duplicate.add(choices[i]);
                //继续选择
                solvePermutationRepeat(state, choices, selected, res);
                //回溯
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }
}
