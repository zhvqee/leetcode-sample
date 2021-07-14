package itcode1;

import java.util.Stack;

public class Solution {

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int s = getAndRemove(stack);
        reverseStack(stack);
        stack.push(s);
    }

    int getAndRemove(Stack<Integer> stack) {
        int s = stack.pop();
        if (stack.isEmpty()) {
            return s;
        }
        int s2 = getAndRemove(stack);
        stack.push(s);
        return s2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        solution.reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
