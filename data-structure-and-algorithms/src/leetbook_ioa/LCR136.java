package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/7
 */
public class LCR136 {
    public ListNode deleteNode(ListNode head, int val) {
        //删除头节点
        if (head.val == val) {
            return head.next;
        }
        //遍历删除
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
