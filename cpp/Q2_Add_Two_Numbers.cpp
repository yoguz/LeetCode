#include <bits/stdc++.h>
#include "common.hpp"
using namespace std;

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
{
    ListNode *prev = new ListNode(0);
    ListNode *head = prev;

    ListNode *p1 = l1, *p2 = l2;
    int carry = 0;
    while (p1 != 0 || p2 != 0)
    {
        int n1 = p1 == 0 ? 0 : p1->val;
        int n2 = p2 == 0 ? 0 : p2->val;

        ListNode *node = new ListNode((n1 + n2 + carry) % 10);
        carry = (n1 + n2 + carry) / 10;
        prev->next = node;
        prev = node;

        p1 = p1 != 0 ? p1->next : p1;
        p2 = p2 != 0 ? p2->next : p2;
    }

    if (carry == 1)
        prev->next = new ListNode(1);

    return head->next;
}

int main()
{

    ListNode *n11 = new ListNode(1, new ListNode(2, new ListNode(3)));
    ListNode *n12 = new ListNode(9, new ListNode(9, new ListNode(9)));

    ListNode *res1 = addTwoNumbers(n11, n12);
    while (res1 != 0)
    {
        cout << res1->val;
        res1 = res1->next;
    }

    cout << endl;
    
    ListNode *n21 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    ListNode *n22 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

    ListNode *res2 = addTwoNumbers(n21, n22);
    while (res2 != 0)
    {
        cout << res2->val;
        res2 = res2->next;
    }

    return 0;
}