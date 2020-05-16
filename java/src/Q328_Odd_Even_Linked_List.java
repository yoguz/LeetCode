import common.ListNode;

public class Q328_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next, even1 = head.next;

        boolean tour = true;
        while(true) {
            if (tour) {
                if (even == null) {
                    odd.next = even1;
                    break;
                }

                if (even.next == null) {
                    odd.next = even1;
                    even.next = null;
                    break;
                }

                odd.next = even.next;
                odd = odd.next;
                tour = false;
            } else {
                even.next = odd.next;
                even = even.next;
                tour = true;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Q328_Odd_Even_Linked_List obj = new Q328_Odd_Even_Linked_List();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        head = obj.oddEvenList(head);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2,3,4});
        head = obj.oddEvenList(head);
        ListNode.printList(head);
    }

}
