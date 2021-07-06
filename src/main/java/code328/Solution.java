package code328;

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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;

        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (odd.next != null) {
            odd.next = odd.next.next;
            if (odd.next != null) {
                odd = odd.next;
            }
            if (even.next != null) {
                even.next = even.next.next;
                even = even.next;
            }

        }
        odd.next = evenHead;
        return head;
    }
}
