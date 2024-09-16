package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/8/8
 */
public class LCR140 {
    //使用距离cnt的双指针共同移动
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode start = head;
        ListNode last = head;
        while (cnt != 0) {
            last = last.next;
            cnt--;
        }
        while (last != null) {
            start = start.next;
            last = last.next;
        }
        return start;
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
