public class Q206_Reverse_Linked_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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

    public static void main(String[] args) {
        Q206_Reverse_Linked_List obj = new Q206_Reverse_Linked_List();
        ListNode head = obj.createList();
        head = obj.reverseListIterative(head);
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println("]");

        head = obj.createList();
        head = obj.reverseListRecursive(head);
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println("]");
    }

    private ListNode createList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = null;
        return n1;
    }
}
