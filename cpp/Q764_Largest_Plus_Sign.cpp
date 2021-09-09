#include <bits/stdc++.h>
using namespace std;

int orderOfLargestPlusSign(int n, vector<vector<int>> mines)
{
    set<int> mineSet;
    int answer = 0, count = 0;

    for (vector<int> mine : mines)
    {
        mineSet.insert(mine[0] * n + mine[1]);
    }

    int dp[n][n];
    for (int c = 0; c < n; ++c)
    {
        for (int r = 0; r < n; ++r)
        {
            dp[r][c] = 1;
        }
    }

    for (vector<int> mine: mines) 
    {
        dp[mine[0]][mine[1]] = 0;
    }

    for (int c = 0; c < n; ++c)
    {
        count = 0;
        for (int r = 0; r < n; ++r)
        {
            count = dp[r][c] == 0 ? 0 : count + 1;
            dp[r][c] = count;
        }

        count = 0;
        for (int r = n - 1; r >= 0; --r)
        {
            count = dp[r][c] == 0 ? 0 : count + 1;
            dp[r][c] = min(count, dp[r][c]);
        }
    }

    for (int r = 0; r < n; ++r)
    {
        count = 0;
        for (int c = 0; c < n; ++c)
        {
            count = dp[r][c] == 0 ? 0 : count + 1;
            dp[r][c] = min(count, dp[r][c]);
        }

        count = 0;
        for (int c = n - 1; c >= 0; --c)
        {
            count = dp[r][c] == 0 ? 0 : count + 1;
            dp[r][c] = min(count, dp[r][c]);
            answer = max(answer, dp[r][c]);
        }
    }

    return answer;
}

int main()
{
    cout << orderOfLargestPlusSign(5, {{4, 2}}) << endl;
    return 0;
}