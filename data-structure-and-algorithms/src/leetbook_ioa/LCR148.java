package leetbook_ioa;

import java.util.Stack;

/**
 * @author CJW
 * @since 2024/8/12
 */
public class LCR148 {
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        //使用一个辅助栈进行模式
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k : putIn) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek().equals(takeOut[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
