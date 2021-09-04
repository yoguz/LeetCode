#include <bits/stdc++.h>
using namespace std;

int BAD;

bool isBadVersion(int version)
{
    return version >= BAD;
}

int firstBadVersion(int n)
{
    int lo = 1, hi = n, mid = 0;

    while (lo < hi)
    {
        mid = lo + (hi - lo) / 2;

        if (isBadVersion(mid))
        {
            hi = mid;
        }
        else
        {
            lo = mid + 1;
        }
    }

    return lo;
}

int main()
{
    BAD = 4;
    cout << firstBadVersion(5) << endl;

    BAD = 3;
    cout << firstBadVersion(100) << endl;
}