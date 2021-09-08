#include <bits/stdc++.h>
#include "common.hpp"
using namespace std;

int maxVal;

int maxPathSum(TreeNode *root)
{
    maxVal = root != 0 ? root->val : 0;
    helper(root);
    return maxVal;
}

int helper(TreeNode *node)
{
    if (node == 0)
    {
        return 0;
    }

    int left = helper(node->left);
    int right = helper(node->right);
    int localMax = max(node->val, max(node->val + left, node->val + right));
    maxVal = max(maxVal, max(localMax, node->val + left + right));
    return localMax;
}

int main()
{
    TreeNode *root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    cout << maxPathSum(root) << endl;

    return 0;
}