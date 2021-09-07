#include <bits/stdc++.h>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}

    void printTree(TreeNode *root)
    {
        vector<vector<string>> lines;

        vector<TreeNode *> level;
        vector<TreeNode *> next;

        level.push_back(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0)
        {
            vector<string> line;

            nn = 0;

            for (TreeNode *n : level)
            {
                if (n == 0)
                {
                    line.push_back("");

                    next.push_back(0);
                    next.push_back(0);
                }
                else
                {
                    string aa = n->val + "";
                    line.push_back(aa);
                    if (aa.length() > widest)
                        widest = aa.length();

                    next.push_back(n->left);
                    next.push_back(n->right);

                    if (n->left != 0)
                        nn++;
                    if (n->right != 0)
                        nn++;
                }
            }

            if (widest % 2 == 1)
                widest++;

            lines.push_back(line);

            vector<TreeNode *> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines[lines.size() - 1].size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++)
        {
            vector<string> line = lines[i];
            int hpw = (int)floor(perpiece / 2.0) - 1;

            if (i > 0)
            {
                for (int j = 0; j < line.size(); j++)
                {
                    if (j % 2 == 1)
                    {
                        if (line[j - 1] != "")
                        {
                            cout << (line[j] != "") ? "┴" : "┘";
                        }
                        else
                        {
                            if (j < line.size() && line[j] != "")
                               cout << "└";
                        }
                    }

                    // lines and spaces
                    if (line[j] == "")
                    {
                        for (int k = 0; k < perpiece - 1; k++)
                        {
                            cout << " ";
                        }
                    }
                    else
                    {

                        for (int k = 0; k < hpw; k++)
                        {
                            cout << (j % 2 == 0 ? " " : "─");
                        }
                        cout << (j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++)
                        {
                            cout << (j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                cout << endl;
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++)
            {

                string f = line[j];

                int gap1 = (int)ceil(perpiece / 2.0 - f.length() / 2.0);
                int gap2 = (int)floor(perpiece / 2.0 - f.length() / 2.0);

                // a number
                for (int k = 0; k < gap1; k++)
                {
                    cout << " ";
                }
                cout << f;
                for (int k = 0; k < gap2; k++)
                {
                    cout << " ";
                }
            }
            cout << endl;

            perpiece /= 2;
        }
    }
};