package code590;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        postOrder(ret, 0, root);
        return ret;
    }

    private void postOrder(List<Integer> ret, int size, Node root) {
        if (root.children == null || root.children.size() == 0 || size == root.children.size() - 1) {
            ret.add(root.val);
        }
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(ret, i, root.children.get(i));
        }
    }
}
