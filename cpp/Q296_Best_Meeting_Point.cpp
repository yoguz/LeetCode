#include <bits/stdc++.h>
using namespace std;

int findMedianX(vector<vector<int>> grid)
{
    vector<int> xs;
    for (size_t i = 0; i < grid.size(); ++i)
    {
        for (size_t j = 0; j < grid[i].size(); ++j)
        {
            if (grid[i][j] == 1)
            {
                xs.push_back(i);
            }
        }
    }

    return xs[xs.size()/2];
}

int findMedianY(vector<vector<int>> grid)
{
    vector<int> ys;
    for (size_t i = 0; i < grid[0].size(); ++i)
    {
        for (size_t j = 0; j < grid.size(); ++j)
        {
            if (grid[j][i] == 1)
            {
                ys.push_back(i);
            }
        }
    }

    return ys[ys.size()/2];
}

int minTotalDistance(vector<vector<int>> grid)
{
    int xMed = findMedianX(grid);
    int yMed = findMedianY(grid);
    int distance = 0;

    for (int i = 0; i < grid.size(); ++i)
    {
        for (int j = 0; j < grid[i].size(); ++j)
        {
            if (grid[i][j] == 1)
            {
                distance += abs(xMed - i) + abs(yMed - j);
            }
        }
    }

    return distance;
}

int main()
{
    cout << minTotalDistance({{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}}) << endl;

    return 0;
}