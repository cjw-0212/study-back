package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/8
 */
public class LCR142 {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode flag = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                flag.next = l1;
                l1 = l1.next;
            } else {
                flag.next = l2;
                l2 = l2.next;
            }
            flag = flag.next;
        }
        //添加剩下的元素
        flag.next = l1 == null ? l2 : l1;
        return newHead.next;
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
