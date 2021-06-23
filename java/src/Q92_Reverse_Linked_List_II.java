import common.ListNode;

public class Q92_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, cur = head;
        int count = 1;
        if (left == right || head == null || head.next == null)
            return head;

        while (count < left) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        ListNode leftNon = prev, leftSwapped = cur;
        prev = cur;
        cur = cur.next;
        count++;

        while (count <= right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        if (leftNon != null)
            leftNon.next = prev;

        leftSwapped.next = cur;

        return left == 1 ? prev : head;
    }

    public static void main(String[] args) {
        Q92_Reverse_Linked_List_II obj = new Q92_Reverse_Linked_List_II();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        ListNode newHead = obj.reverseBetween(head, 2, 4);
        ListNode.printList(newHead);
    }

}


