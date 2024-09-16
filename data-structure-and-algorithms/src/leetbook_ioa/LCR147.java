package leetbook_ioa;

import java.util.Stack;

/**
 * @author CJW
 * @since 2024/8/12
 */
public class LCR147 {
    private Stack<Integer> A, B;

    public LCR147() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.empty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}
