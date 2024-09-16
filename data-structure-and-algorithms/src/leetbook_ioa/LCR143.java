package leetbook_ioa;


/**
 * @author CJW
 * @since 2024/8/8
 */
public class LCR143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //为空不匹配
        return (A != null && B != null) &&
                //A当前节点开始匹配||A左子树匹配||A右子树匹配
                (recursion(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 两个根节点的树是否匹配
     */
    private static boolean recursion(TreeNode A, TreeNode B) {
        //B树匹配完成
        if (B == null) {
            return true;
        }
        //A树到达空节点或者两者的值不同
        if (A == null || A.val != B.val) {
            return false;
        }
        //继续匹配左右子节点
        return recursion(A.left, B.left) && recursion(A.right, B.right);
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
