package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/8
 */
public class LCR141 {
    public ListNode trainningPlan(ListNode head) {
        //反转链表
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
