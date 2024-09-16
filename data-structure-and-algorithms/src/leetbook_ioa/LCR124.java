package leetbook_ioa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2024/8/1
 */
public class LCR124 {
    private static Map<Integer, Integer> map = new HashMap<>();

    /**
     * preorder 和 inorder 中均不含重复数字。
     */
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        //由于不存在相同的元素，将中序遍历的值与索引的键值对存储起来，便于后续在中序遍历中寻找根节点的位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(0, 0, inorder.length - 1, preorder);
    }

    /**
     * 递归获取二叉树
     *
     * @param root  在前序遍历中根节点的索引
     * @param left  树在中序遍历中的左边界
     * @param right 树在中序遍历中的右边界
     * @return
     */
    private static TreeNode recursion(int root, int left, int right, int[] preorder) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        //找到中序遍历中根节点的索引
        int i = map.get(preorder[root]);
        node.left = recursion(root + 1, left, i - 1, preorder);
        //右子树根节点为root索引+左子树长度+1
        node.right = recursion(root + i - left + 1, i + 1, right, preorder);
        return node;
    }

    private static class TreeNode {
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
