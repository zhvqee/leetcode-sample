package code160;

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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == p2) {
            return p1;
        }
        int cp1 = 0;
        int cp2 = 0;
        while (p1 != p2) {
            if (cp1 == 0 && p1 == null) {
                p1 = headB;
                cp1 = 1;
                continue;
            } else if (p1 == null) {
                break;
            }
            if (cp2 == 0 && p2 == null) {
                p2 = headA;
                cp2 = 1;
                continue;
            } else if (p2 == null) {
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;

    }
}
