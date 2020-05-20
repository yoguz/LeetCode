import common.ListNode;

public class Q21_Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null? l2:l1;
        return head;
    }

    public static void main(String[] args) {
        Q21_Merge_Two_Sorted_Lists obj = new Q21_Merge_Two_Sorted_Lists();
        ListNode head1 = ListNode.createList(new int[]{1,2,4});
        ListNode head2 = ListNode.createList(new int[]{1,3,4});
        ListNode newHead = obj.mergeTwoLists(head1, head2);
        ListNode.printList(newHead);
    }
}
