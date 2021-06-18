import common.ListNode;

public class Q206_Reverse_Linked_List {

    public ListNode reverseListIterative(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null)
            return null;

        return reverseListRecursiveHelper(null, head);
    }

    private ListNode reverseListRecursiveHelper(ListNode prev, ListNode cur) {
        if (cur == null)
            return prev;

        ListNode next;
        next = cur.next;
        cur.next = prev;
        return reverseListRecursiveHelper(cur, next);
    }

    public ListNode reverseList(ListNode head) {
        if ( head == null )
            return null;

        ListNode firstHead = head, temp = head.next, temp2;

        while (head != null && temp != null) {
            temp2 = temp.next;
            temp.next = head;
            head = temp;
            temp = temp2;
        }

        firstHead.next = null;
        return head;
    }

    public static void main(String[] args) {
        Q206_Reverse_Linked_List obj = new Q206_Reverse_Linked_List();
        int[] nodes = new int[]{1,2,3,4,5};

        ListNode head = ListNode.createList(nodes);
        ListNode.printList(head);
        head = obj.reverseListIterative(head);
        ListNode.printList(head);

        head = ListNode.createList(nodes);
        ListNode.printList(head);
        head = obj.reverseListRecursive(head);
        ListNode.printList(head);
    }
}
