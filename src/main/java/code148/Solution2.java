package code148;

public class Solution2 {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLength(head);
        int step = 1;
        ListNode cur = head;


        ListNode head1 = head;
        ListNode head2 = head;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        ListNode preHead2 = head2;
        for (int i = 0; i < step && head2 != null; i++) {
            preHead2 = head2;
            head2 = head2.next;
        }
        //cur = goToNext(head2, step);

        // 断开之前的链路
        preHead2.next = null;
        p.next = merge(head1, head2);
        p = movetail(p);

        return null;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        return null;
    }

    ListNode[] goToNext(ListNode cur, int step) {
        ListNode pre = cur;
        for (int i = 0; i < step && cur != null; i++) {
            pre = cur;
            cur = cur.next;
        }
        return new ListNode[]{cur,};
    }

    ListNode movetail(ListNode p) {
        while (p != null && p.next != null) {
            p = p.next;
        }
        return p;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            p = p.next;
            cnt++;
        }
        return cnt;
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
        Solution2 solution = new Solution2();
        ListNode head = solution.constructList(new int[]{-1, 5, 3, 4, 0});

        ListNode listNode = solution.sortList(head);
        System.out.println(listNode);
    }

}
