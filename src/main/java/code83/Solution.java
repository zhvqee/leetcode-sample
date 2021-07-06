package code83;

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null) {
            if (pre.val != p.val) {
                pre = p;
                p = p.next;
            } else {
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            }
        }
        return head;
    }
}
