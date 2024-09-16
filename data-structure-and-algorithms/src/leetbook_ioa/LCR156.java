package leetbook_ioa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CJW
 * @since 2024/8/15
 */
public class LCR156 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(serialize(root));
        TreeNode deserialize = deserialize("[2,1,3,null,null,null,null]");
        System.out.println(deserialize.val);
        System.out.println(deserialize.left.val);
        System.out.println(deserialize.right.val);
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        //采用层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                ans.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                ans.append("null" + ",");
            }
        }
        ans.deleteCharAt(ans.length() - 1);
        return "[" + ans + "]";
    }

    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] val = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(val[i])) {
                node.left = new TreeNode(Integer.parseInt(val[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(val[i])) {
                node.right = new TreeNode(Integer.parseInt(val[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
