import common.ListNode;

public class Q141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode p1 = head.next, p2 = p1.next;
        while (p1.next != null && p2.next != null && p2.next.next != null) {
            if (p1 == p2)
                return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Q141_Linked_List_Cycle obj = new Q141_Linked_List_Cycle();
        ListNode head = ListNode.createList(new int[]{1,2,3});
        head.next.next = head.next;
        System.out.println(obj.hasCycle(head));
    }
}
