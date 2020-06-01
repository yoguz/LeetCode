import common.ListNode;

public class Q19_Remove_Nth_Node_From_End_of_List {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode before = head, iter = head;
        while (n >= 0) {
            if (iter == null)
                return head.next;

            iter = iter.next;
            n--;
        }

        while (iter != null) {
            iter = iter.next;
            before = before.next;
        }

        before.next = before.next.next;
        return head;
    }

    public static void main(String[] args) {
        Q19_Remove_Nth_Node_From_End_of_List obj = new Q19_Remove_Nth_Node_From_End_of_List();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        head = obj.removeNthFromEnd(head, 1);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2,3,4,5});
        head = obj.removeNthFromEnd(head, 2);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2,3,4,5});
        head = obj.removeNthFromEnd(head, 5);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1});
        head = obj.removeNthFromEnd(head, 1);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2});
        head = obj.removeNthFromEnd(head, 1);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2});
        head = obj.removeNthFromEnd(head, 2);
        ListNode.printList(head);
    }
}
