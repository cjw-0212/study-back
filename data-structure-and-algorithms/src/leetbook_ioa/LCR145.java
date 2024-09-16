package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/12
 */
public class LCR145 {
    public boolean checkSymmetricTree(TreeNode root) {
        return root == null || recursion(root.left, root.right);
    }

    private static boolean recursion(TreeNode left, TreeNode right) {
        //两者都为空
        if (left == null && right == null) {
            return true;
        }
        //一个为空一个不为空
        //都不为空但是值不相等
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
