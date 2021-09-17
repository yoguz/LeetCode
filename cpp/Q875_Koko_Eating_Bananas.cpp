#include <bits/stdc++.h>
using namespace std;

bool isPossible(vector<int> &piles, int h, int k) {
    int total = 0;
    for (auto pile: piles) {
        total += ceil(pile * 1.0 / k);
    }

    return total <= h;
}

int minEatingSpeed(vector<int> piles, int h)
{
    int lo = 1, hi = *max_element(piles.begin(), piles.end());
    while (lo < hi) {
        int k = lo + (hi - lo) / 2;
        if (!isPossible(piles, h, k))
            lo = k + 1;
        else
            hi = k;
    }

    return lo;
}

int main()
{
    cout << minEatingSpeed({3,6,7,11}, 8) << "\n";
    cout << minEatingSpeed({30,11,23,4,20}, 6) << "\n";

    return 0;
}