package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/6
 */
public class LCR171 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null ? a.next : headB);
            b = (b != null ? b.next : headA);
        }
        return a;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
