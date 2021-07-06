package code21;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head =new ListNode();
        ListNode p=head;
        while(l1!=null && l2 !=null){
            if(l1.val <=l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1!=null){
            p.next=l1;
        }
        if(l2 !=null){
            p.next=l2;
        }
        p=head;
        head=head.next;
        p.next=null;
        return head;
    }
}
