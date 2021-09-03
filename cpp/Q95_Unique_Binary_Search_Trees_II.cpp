#include <bits/stdc++.h>
#include "common.hpp"
using namespace std;

void helper(vector<TreeNode*>& trees, int min, int max)
{
    if (min > max)
    {
        trees.push_back(0);
        return;
    }
    else if (min == max)
    {
        trees.push_back(new TreeNode(min));
        return;
    }

    for (int i = min; i <= max; ++i)
    {
        vector<TreeNode*> lefts, rights;
        helper(lefts, min, i-1);
        helper(rights, i+1, max);
        for (TreeNode* left: lefts)
        {
            for (TreeNode* right: rights)
            {
                TreeNode* root = new TreeNode(i);
                root->left = left;
                root->right = right;
                trees.push_back(root);
            }
        }
    }
    
}

vector<TreeNode*> generateTrees(int n)
{
    vector<TreeNode*> trees;
    helper(trees, 1, n);
    return trees;
}

int main()
{
    vector<TreeNode*> trees = generateTrees(3);
    for (TreeNode* root: trees)
    {
        cout << "root:" << root->val << endl;
        if (root->left != 0)
            cout << "left:" << root->left->val << endl;
        if (root->right != 0)
            cout << "right:" << root->right->val << endl;

        if (root->left != 0 && root->left->left != 0)
            cout << "left-left:" << root->left->left->val << endl;
        if (root->left != 0 && root->left->right != 0)
            cout << "left-right:" << root->left->right->val << endl;

        if (root->right && root->right->left != 0)
            cout << "right-left:" << root->right->left->val << endl;
        if (root->right && root->right->right != 0)
            cout << "right-right:" << root->right->right->val << endl;

        cout << endl;
    }

    return 0;
}