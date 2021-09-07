#include <bits/stdc++.h>
#include "common.hpp"
using namespace std;

ListNode *reverseList(ListNode *head)
{
    ListNode *prev = nullptr, *cur = head, *next;
    while (cur != 0)
    {
        next = cur->next;
        cur->next = prev;
        prev = cur;
        cur = next;
    }

    return prev;
}

int main()
{
    ListNode *head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(5)))));
    ListNode *reversed = reverseList(head);
    while (reversed != 0)
    {
        cout << reversed->val << " -> ";
        reversed = reversed->next;
    }
    cout << endl;
    
    return 0;
}