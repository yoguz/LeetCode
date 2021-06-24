import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q23_Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode head: lists) {
            if (head != null) {
                q.add(head);
            }
        }

        if (q.size() == 0)
            return null;

        ListNode head = q.poll();
        ListNode cur = head, next;

        while(q.size() > 0) {
            if (cur.next != null)
                q.add(cur.next);

            next = q.poll();
            cur.next = next;
            cur = next;
        }

        return head;
    }

    public static void main(String[] args) {
        Q23_Merge_k_Sorted_Lists obj = new Q23_Merge_k_Sorted_Lists();
        ListNode h1 = ListNode.createList(new int[]{0,1,3,5,6,7});
        ListNode h2 = ListNode.createList(new int[]{2,3,4,5,8,9});
        ListNode h3 = ListNode.createList(new int[]{5,10});
        ListNode newHead = obj.mergeKLists(new ListNode[]{h1,h2,h3});
        ListNode.printList(newHead);
    }
}
