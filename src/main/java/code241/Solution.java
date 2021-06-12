package code241;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() <= 0) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> curRes = new ArrayList<Integer>();
        int length = input.length();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < length; i++) {
            char aChar = charArray[i];
            if (aChar == '+' || aChar == '-' || aChar == '*') { // 当前字符为 操作符
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (aChar == '+') {
                            curRes.add(leftNum + rightNum);
                        } else if (aChar == '-') {
                            curRes.add(leftNum - rightNum);
                        } else {
                            curRes.add(leftNum * rightNum);
                        }
                    }
                }

            }
        }

        if (curRes.isEmpty()) {
            curRes.add(Integer.valueOf(input));
        }
        return curRes;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        List<Integer> list = solution.diffWaysToCompute("2-1-1-5-3-3-53-2");
        System.out.println(list);
    }
}
