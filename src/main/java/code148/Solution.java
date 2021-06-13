package code148;

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

    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }

    /**
     * 归并排序
     *
     * @return
     */
    public ListNode mergeSort(ListNode head, ListNode end) {
        if (head == end || head.next == end) {
            return head;
        }
        ListNode midNode = getMidNode(head, end);
        ListNode head1 = mergeSort(head, midNode);
        ListNode head2 = mergeSort(midNode, end);
        return merge(head1, midNode,head2, end);
    }

    private ListNode merge(ListNode head1,ListNode end0, ListNode head2, ListNode end) {
        ListNode head = new ListNode();
        ListNode p = head;
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != end0 && p2 != end) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        while (p1 != end0) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != end) {
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        p.next = end;


        p = head;
        head = head.next;
        p.next = null;
        return head;
    }


    /**
     * 中间指针
     *
     * @param head
     * @return
     */
    private ListNode getMidNode(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head;
        if (head == end) {
            return p1;
        }

        while (p1 != end && p1.next != end) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
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
        ListNode head = solution.constructList(new int[]{-1,5,3,4,0});

        ListNode listNode = solution.sortList(head);
        System.out.println(listNode);
    }

}
