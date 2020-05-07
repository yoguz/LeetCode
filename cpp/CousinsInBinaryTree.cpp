/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#include<iostream>
#include<queue>
#include<unordered_map>


class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        int depthx = -1;
        int depthy = -1;
        
        TreeNode* parentX = nullptr;
        TreeNode* parentY = nullptr;
        
        findDepth(root, root,x, 0, depthx, &parentX);
        findDepth(root, root, y, 0, depthy, &parentY);
        
        if(depthx != -1){
            return (depthx == depthy) && (parentX != parentY);
        }

    
        return false;
    }
    
    void findDepth(TreeNode* root,TreeNode*cParent, int x, int depth, int& depthP, TreeNode** parent){
        
        if(root == nullptr){
            return;
        }
        if(root->val == x){
            *parent = cParent;
            depthP = depth;
            return;
        }
        
        findDepth(root->left,root, x, depth+1, depthP, parent);
        findDepth(root->right, root, x, depth+1, depthP, parent);
    }
    
};