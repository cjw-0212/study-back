package leetbook_ioa;

import javax.swing.tree.TreeNode;

/**
 * @author CJW
 * @since 2024/9/11
 */
public class LCR176 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 采用自底向上的方式进行递归
     *
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        //代表不符合平衡二叉树
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        //符合的话返回数的最大高度
        return Math.max(leftHeight, rightHeight) + 1;
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
