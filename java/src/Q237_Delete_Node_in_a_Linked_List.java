import common.ListNode;

public class Q237_Delete_Node_in_a_Linked_List {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while (next.next != null) {
            node.val = next.val;
            node = next;
            next = node.next;
        }
        node.val = next.val;
        node.next = null;
    }

    public void deleteNodeQuicker(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Q237_Delete_Node_in_a_Linked_List obj = new Q237_Delete_Node_in_a_Linked_List();
        ListNode head = ListNode.createList(new int[]{1,2,3,4,5});
        obj.deleteNode(head.next.next);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2});
        obj.deleteNode(head);
        ListNode.printList(head);
        head = ListNode.createList(new int[]{1,2,3});
        obj.deleteNode(head.next);
        ListNode.printList(head);
    }
}
