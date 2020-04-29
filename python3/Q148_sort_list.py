# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        
        if head is None:
            return
        
        if head.next is None:
            return head
        
        fast = ListNode(float("inf"))
        fast = head
        #fast.next = head
        
        slow = ListNode(float("inf"))
        slow = head
        #slow.next = head
        prev = None
        while fast and fast.next:
            fast = fast.next.next
            prev = slow
            slow = slow.next
        
        prev.next = None
        
        
        left_head = self.sortList(head)
        right_head = self.sortList(slow)
        
        new_head = ListNode(-1)
        root = new_head
        
        while left_head and right_head:
            
            if left_head.val < right_head.val:
                new_head.next = left_head
                left_head = left_head.next
                
            else:
                new_head.next = right_head
                right_head = right_head.next
                
            new_head = new_head.next
            
            
        if left_head:
            new_head.next = left_head
            
        if right_head:
            new_head.next = right_head
            
            
        return root.next   
            
            
        
        