#include <bits/stdc++.h>
#include "common.hpp"
using namespace std;

double maxValue = 0;

pair<int, int> helper(TreeNode* node)
{
    if (node == 0)
        return {0, 0};
    
    pair<int, int> left = helper(node->left);
    pair<int, int> right = helper(node->right);

    int sumof = (left.first + node->val + right.first);
    int count = (left.second + right.second + 1);
    maxValue = max(maxValue, sumof * 1.0 / count);    

    return {sumof, count};
}

double maximumAverageSubtree(TreeNode *root)
{
    helper(root);
    return maxValue;
}

int main()
{
    TreeNode n1(1);
    TreeNode n2(2);
    n2.right = &n1;

    cout << maximumAverageSubtree(&n2) << endl;

    return 0;
}