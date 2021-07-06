package code232;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> deque1;
    private Stack<Integer> deque2;


    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        deque1 = new Stack<>();
        deque2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        deque1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!deque2.isEmpty()) {
            return deque2.pop();
        }
        slip();
        return deque2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!deque2.isEmpty()) {
            return deque2.peek();
        }
        slip();
        return deque2.pop();
    }


    private void slip() {
        while (!deque1.isEmpty()) {
            deque2.push(deque1.pop());
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return deque2.isEmpty() && deque1.isEmpty();
    }

}
