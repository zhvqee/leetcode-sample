package code155;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
            stack.push(val);
            return;
        }
        int min = minStack.peek();
        minStack.push(Math.min(min, val));
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
