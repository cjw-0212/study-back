package leetbook_ioa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/8/14
 */
public class LCR153 {

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recur(root, target, path, ans);
        return ans;
    }

    private static void recur(TreeNode node, int target, List<Integer> path, List<List<Integer>> ans) {
        //为空直接返回
        if (node == null) {
            return;
        }
        //加入路径并更新target值
        path.add(node.val);
        target -= node.val;
        //满足条件记录答案
        if (target == 0 && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        recur(node.left, target, path, ans);
        recur(node.right, target, path, ans);
        //路径回溯
        path.remove(path.size() - 1);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
