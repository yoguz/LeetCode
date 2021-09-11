#include <bits/stdc++.h>
using namespace std;

double angleClock(int hour, int minutes)
{
    double hHand = (hour % 12) * 30 + (minutes / 60.0 * 30);
    double mHand = minutes * 6;
    double diff = abs(mHand - hHand);

    return min(diff, 360 - diff);
}

int main()
{
    cout << angleClock(4, 50) << "\n";
    cout << angleClock(3, 30) << "\n";

    return 0;
}