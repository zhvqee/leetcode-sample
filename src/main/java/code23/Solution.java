package code23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        ListNode dumy = new ListNode(0);
        ListNode tail = dumy;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            tail.next = poll;
            tail = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
        }
        return dumy.next;
    }
}
