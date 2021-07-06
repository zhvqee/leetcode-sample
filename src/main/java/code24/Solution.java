package code24;

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

    public ListNode swapPairs2(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            int val = p.val;
            p.val = p.next.val;
            p.next.val = val;
            p = p.next.next;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = head.next;
        head.next=swapPairs(head.next.next);
        newNode.next=head;
        return newNode;
    }


}
