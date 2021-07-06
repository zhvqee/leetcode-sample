package code234;

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

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head, p2 = head;
        if (head == null) {
            return true;
        }

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 奇数 链
        if (p2 != null) {
            p1 = p1.next;
        }
        p2 = head;

        // 旋转 p1;
        p1 = convert(p1);

        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode convert(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = convert(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    ListNode insertNode(ListNode head, int e) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(e, null);
        return head;
    }

    ListNode constructList(int[] arr) {
        ListNode head = new ListNode();
        for (int a : arr) {
            head = insertNode(head, a);
        }
        ListNode p = head;
        head = head.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.constructList(new int[]{1, 1, 2, 1});
        boolean palindrome = solution.isPalindrome(listNode);
        System.out.println(palindrome);


    }

}
