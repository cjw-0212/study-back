package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/11
 */
public class LCR175 {
    public int calculateDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(calculateDepth(root.left),calculateDepth(root.right))+1;
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
