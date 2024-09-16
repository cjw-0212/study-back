package leetbook_ioa;

import java.util.Stack;

/**
 * @author CJW
 * @since 2024/8/13
 */
public class LCR152 {
    public boolean verifyTreeOrder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1);
    }

    private static boolean recursion(int[] postorder, int i, int j) {
        //只剩下一个节点
        if (i >= j) {
            return true;
        }
        //找到第一个大于根节点的值
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        //找到比根节点的最后一个节点的下一个位置
        while (postorder[p] > postorder[j]) {
            p++;
        }
        //如果p==j表示当前的分树操作是正确的，不然就可以认为无法往下分树则不是后序遍历二叉搜索树
        return p == j && recursion(postorder, i, m - 1) && recursion(postorder, m, j - 1);
    }

    public boolean verifyTreeOrder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i]>root){
                return false;
            }
            while (!stack.isEmpty()&&postorder[i]<stack.peek()){
                root=stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
