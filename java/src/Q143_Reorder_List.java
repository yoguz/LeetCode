import common.ListNode;

public class Q143_Reorder_List {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode fast = head.next.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode head2 = reverse(slow);
        merge(head, head2);
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, next = node.next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode tmp1, tmp2;
        while(l1 != null && l2 != null) {
            tmp1 = l1.next;
            tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }

    public static void main(String[] args) {
        Q143_Reorder_List obj = new Q143_Reorder_List();

        ListNode head = ListNode.createList(new int[]{1,2,3});
        obj.reorderList(head);
        ListNode.printList(head);

        head = ListNode.createList(new int[]{1,2,3,4});
        obj.reorderList(head);
        ListNode.printList(head);

        head = ListNode.createList(new int[]{1,2,3,4,5});
        obj.reorderList(head);
        ListNode.printList(head);
    }
}
