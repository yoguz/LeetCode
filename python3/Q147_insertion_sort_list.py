class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        
        dummy = ListNode(float('-inf'))
        dummy.next = head
        end = head
        runner = end.next
        
        while runner:
            if runner.val >= end.val:
                end, runner = runner, runner.next
            else:
                put = dummy
                while put.next.val < runner.val:
                    put = put.next
				# find the location to insert node
                
                end.next = runner.next
                runner.next = put.next
                put.next = runner
				# insert
                
                runner = end.next
				# update runner
        
        return dummy.next