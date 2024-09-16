package leetbook_ioa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2024/8/14
 */
public class LCR154 {
    public Node copyRandomList(Node head) {
        //先创建全部节点并用hash记录然后再
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //连接
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
