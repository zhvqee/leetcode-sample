package code1028;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Node {
        int value;
        int depth;
        TreeNode treeNode;

        public Node(int value, int depth, TreeNode treeNode) {
            this.value = value;
            this.depth = depth;
            this.treeNode = treeNode;
        }
    }

    public TreeNode recoverFromPreorder(String traversal) {
        List<Node> nodeList = translate(traversal);
        Stack<Node> stack = new Stack<>();

        Node node = nodeList.get(0);
        TreeNode head = node.treeNode;
        int preDepth = node.depth;
        TreeNode parant = head;
        stack.push(node);
        for (int i = 1; i < nodeList.size(); i++) {
            node = nodeList.get(i);
            TreeNode treeNode = node.treeNode;
            while (parant != null) {
                if (node.depth - 1 == preDepth) {
                    if (parant.left == null) {
                        parant.left = treeNode;
                    } else {
                        parant.right = treeNode;
                    }
                    preDepth = node.depth;
                    parant = treeNode;
                    stack.push(node);
                    break;
                } else {
                    Node tmp = stack.pop();
                    parant = tmp.treeNode;
                    preDepth = tmp.depth;
                }
            }
        }
        return head;
    }

    private List<Node> translate(String traversal) {
        char[] toCharArray = traversal.toCharArray();

        List<Node> result = new ArrayList<>();

        int i = 0;
        StringBuffer bf = new StringBuffer();
        for (i = 0; i < toCharArray.length; i++) {
            if (toCharArray[i] != '-') {
                bf.append(toCharArray[i]);
            } else {
                break;
            }
        }

        int value = Integer.parseInt(bf.toString());
        result.add(new Node(value, 0, new TreeNode(value)));

        int depth = 0;

        for (; i < toCharArray.length; ) {
            if (toCharArray[i] != '-') {
                StringBuffer bfs = new StringBuffer();
                while (i < toCharArray.length) {
                    if (toCharArray[i] != '-') {
                        bfs.append(toCharArray[i]);
                        i++;
                    } else {
                        break;
                    }
                }
                value = Integer.parseInt(bfs.toString());
                result.add(new Node(value, depth, new TreeNode(value)));
                depth = 0;
            } else {
                depth++;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recoverFromPreorder("3");
    }
}
