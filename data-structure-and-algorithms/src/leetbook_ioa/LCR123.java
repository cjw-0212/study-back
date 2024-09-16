package leetbook_ioa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/31
 */
public class LCR123 {
    public int[] reverseBookList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        recursion(head, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void recursion(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        recursion(head.next, list);
        list.add(head.val);
    }

    /**
     * 采用头插法进行反转链表
     */
    public int[] reverseBookList1(ListNode head) {
        //定义一个空的新头节点
        ListNode newHead = new ListNode();
        int count = 0;
        while (head != null) {
            //进行计算方便后续遍历
            count++;
            //链表记录下一节点地址
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        int[] res = new int[count];
        int k = 0;
        while (newHead.next != null) {
            res[k++] = newHead.next.val;
            newHead = newHead.next;
        }
        return res;
    }

    private static class ListNode {
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

