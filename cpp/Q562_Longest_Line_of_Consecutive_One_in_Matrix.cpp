#include <bits/stdc++.h>
using namespace std;

int longestLine3pass(vector<vector<int>> &M) // 3 pass
{
    if (M.empty() || M[0].empty())
        return 0;
    int m = M.size(), n = M[0].size();
    int maxl = 0, hori = 0, vert = 0, inc = 0, desc = 0;
    for (int i = 0; i < m; i++)
        for (int j = 0, hori = 0; j < n; j++, maxl = max(maxl, hori))
            hori = M[i][j] ? hori + 1 : 0;

    for (int j = 0; j < n; j++)
        for (int i = 0, vert = 0; i < m; i++, maxl = max(maxl, vert))
            vert = M[i][j] ? vert + 1 : 0;

    for (int k = 0; k < m + n; k++)
    {
        for (int i = min(k, m - 1), j = max(0, k - m), inc = 0; i >= 0 && j < n; i--, j++, maxl = max(maxl, inc))
            inc = M[i][j] ? inc + 1 : 0;
        for (int i = max(m - 1 - k, 0), j = max(0, k - m), desc = 0; i < m && j < n; i++, j++, maxl = max(maxl, desc))
            desc = M[i][j] ? desc + 1 : 0;
    }
    return maxl;
}

int longestLine(vector<vector<int>> &M)
{
    int H = M.size(), W = H ? M[0].size() : 0, res = 0;
    vector<vector<vector<int>>> dp(H, vector<vector<int>>(W, vector<int>(4, 0)));
    for (int i = 0; i < H; i++)
        for (int j = 0; j < W; j++)
            if (M[i][j] == 1)
            {
                res = max(res, dp[i][j][0] = 1 + (j ? dp[i][j - 1][0] : 0));                  // horizontal
                res = max(res, dp[i][j][1] = 1 + (i ? dp[i - 1][j][1] : 0));                  // vertical
                res = max(res, dp[i][j][2] = 1 + (i && j ? dp[i - 1][j - 1][2] : 0));         // diagonal
                res = max(res, dp[i][j][3] = 1 + (i && j < W - 1 ? dp[i - 1][j + 1][3] : 0)); // anti-diagonal
            }
    return res;
}

int main()
{
}