package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/12
 */
public class LCR144 {
    public TreeNode mirrorTree(TreeNode root) {
        recursion(root);
        return root;
    }

    private static void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recursion(root.left);
        recursion(root.right);
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

