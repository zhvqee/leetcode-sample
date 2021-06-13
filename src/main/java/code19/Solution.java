package code19;

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpHead = new ListNode(0, head);
        ListNode p = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            p2 = p.next;
        }
        p = p2.next;
        p2.next = p2.next.next;
        p.next = null;
        head = tmpHead.next;
        tmpHead.next = null;
        return head;
    }
}
