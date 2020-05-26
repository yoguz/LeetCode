import common.ListNode;

public class Q234_Palindrome_Linked_List {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode node = head;
        int count = 0, total = 0;
        while(node.next != null) {
            count++;
            node = node.next;
        }
        count++;
        total = count;
        count /= 2;
        node = head;
        while (count > 0) {
            node = node.next;
            count--;
        }

        ListNode temp, temp2;
        temp = node.next;
        while (temp != null) {
            temp2 = temp.next;
            temp.next = node;
            node = temp;
            temp = temp2;
        }

        count = total/2;
        while (count > 0) {
            if (node.val != head.val)
                return false;
            node = node.next;
            head = head.next;
            count--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q234_Palindrome_Linked_List obj = new Q234_Palindrome_Linked_List();
        ListNode head = ListNode.createList(new int[]{1,3,4,3,1});
        System.out.println(obj.isPalindrome(head));
        head = ListNode.createList(new int[]{});
        System.out.println(obj.isPalindrome(head));
        head = ListNode.createList(new int[]{1});
        System.out.println(obj.isPalindrome(head));
        head = ListNode.createList(new int[]{1,1});
        System.out.println(obj.isPalindrome(head));
        head = ListNode.createList(new int[]{1,2});
        System.out.println(obj.isPalindrome(head));
        head = ListNode.createList(new int[]{1,2,1});
        System.out.println(obj.isPalindrome(head));
        head = ListNode.createList(new int[]{1,2,2});
        System.out.println(obj.isPalindrome(head));
    }
}
