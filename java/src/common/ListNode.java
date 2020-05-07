package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] arr) {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head, next;
        for (int i = 1; i < arr.length; ++i) {
            next = new ListNode(arr[i]);
            cur.next = next;
            cur = next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            sb.append(",");
            head = head.next;
        }

        if (sb.length() > 1)
            sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
