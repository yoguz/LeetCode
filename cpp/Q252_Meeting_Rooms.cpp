#include <bits/stdc++.h>
using namespace std;

bool canAttendMeetings(vector<vector<int>> &intervals)
{
    sort(intervals.begin(), intervals.end(), [](auto &a, auto &b)
         { return a[0] < b[0]; });
    for (size_t i = 1; i < intervals.size(); ++i)
    {
        if (intervals[i][0] < intervals[i - 1][1])
            return false;
    }
    return true;
}

int main()
{
    return 0;
}