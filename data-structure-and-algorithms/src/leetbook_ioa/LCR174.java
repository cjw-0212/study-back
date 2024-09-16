package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/11
 */
public class LCR174 {
    private int res;
    private int cnt;

    public int findTargetNode(TreeNode root, int cnt) {
        this.cnt = cnt;
        //右根左遍历，并同时cnt计算位置
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        //如果为0则提前回溯
        if (cnt == 0) {
            return;
        }
        cnt--;
        if (cnt == 0) {
            res = node.val;
        }
        dfs(node.left);
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
