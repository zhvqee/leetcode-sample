package code206;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode q = null;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}
