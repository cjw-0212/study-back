package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/14
 */
public class LCR155 {
    private Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recur(root);
        //链表首尾连接
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 采用中序遍历搜索二叉树就是递增的顺序
     */
    private void recur(Node cur) {
        if (cur == null) {
            return;
        }
        recur(cur.left);
        //如果pre为空代表访问的是叶子节点，也就是链表的头
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        //记录当前节点
        pre = cur;
        recur(cur.right);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
