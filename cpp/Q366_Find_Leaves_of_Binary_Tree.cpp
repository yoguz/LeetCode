#include <bits/stdc++.h>
#include "common.hpp"
using namespace std;

int helper(TreeNode *node, vector<vector<int>> &res)
{
    if (node == 0)
        return 0;

    int level = max(helper(node->left, res), helper(node->right, res));
    if (level >= res.size())
        res.resize(level + 1);

    res[level].push_back(node->val);
    return level + 1;
}

vector<vector<int>> findLeaves(TreeNode *root)
{
    vector<vector<int>> res;
    helper(root, res);
    return res;
}

int main()
{
    TreeNode *root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
    vector<vector<int>> res = findLeaves(root);
    for (auto &lev : res)
    {
        for (auto &n : lev)
        {
            cout << n << " ";
        }
        cout << "\n";
    }

    return 0;
}