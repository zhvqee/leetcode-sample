package code02_02;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        int i = 0;
        while (i < k) {
            p2 = p2.next;
            i++;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.val;
    }
}
