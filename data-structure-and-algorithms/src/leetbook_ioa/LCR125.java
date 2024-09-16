package leetbook_ioa;

import java.util.LinkedList;

/**
 * @author CJW
 * @since 2024/8/1
 */
public class LCR125 {
    class CQueue {
        LinkedList<Integer> aList, blist;

        public CQueue() {
            aList = new LinkedList<>();
            blist = new LinkedList<>();
        }

        public void appendTail(int value) {
            aList.addLast(value);
        }

        public int deleteHead() {
            if (!blist.isEmpty()) {
                return blist.removeLast();
            }
            if (aList.isEmpty()) {
                return -1;
            }
            while (!aList.isEmpty()) {
                blist.addLast(aList.removeLast());
            }
            return blist.removeLast();
        }
    }
}
