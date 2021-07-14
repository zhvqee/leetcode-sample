package code331;

import java.util.Stack;

public class Solution {
    private int i = 0;

    // 非叶子节点，出度是2，入度是1，根节点出度2，叶子节点入度是1
    //完全二叉树，出度和-入度和=0
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if(nodes.length==1 && nodes[0].equals("#")){
            return true;
        }
        if (nodes.length > 1 && nodes[0].equals("#")) {
            return false;
        }
        int du = 2;
        for (int i = 1; i < nodes.length; i++) {
            du--;
            if (du < 0) {
                return false;
            }
            if (!nodes[i].equals("#")) {
                du += 2;
            }
        }
        return du==0;
    }

    public boolean isValidSerialization2(String preorder) {

        Stack<String> stack = new Stack<>();
        i = 0;
        String cur = null;
        while ((cur = getStr(preorder)) != null) {
            if (cur.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.peek().equals("#")) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    private String getStr(String preorder) {
        int begin = i;
        while (i < preorder.length() && preorder.charAt(i) != ',') {
            i++;
        }
        if (i > preorder.length()) {
            return null;
        }
        String substring = preorder.substring(begin, i);
        i++;
        if (substring.equals("")) {
            return null;
        }
        return substring;
    }


    public static void main(String[] args) {
        String s = "#";
        Solution solution = new Solution();
        boolean validSerialization = solution.isValidSerialization(s);
        System.out.println(validSerialization);
    }
}
