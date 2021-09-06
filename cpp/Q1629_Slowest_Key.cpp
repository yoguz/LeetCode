#include <bits/stdc++.h>
using namespace std;

char slowestKey(vector<int> releaseTimes, string keysPressed)
{
    int maxDuration = releaseTimes[0];
    char slowestKey = keysPressed[0];
    int duration = 0;

    for (size_t i = 1; i < releaseTimes.size(); ++i)
    {
        duration = releaseTimes[i] - releaseTimes[i - 1];
        if (duration > maxDuration ||
            (duration == maxDuration && keysPressed[i] > slowestKey))
        {
            maxDuration = duration;
            slowestKey = keysPressed[i];
        }
    }

    return slowestKey;
}

char slowestKey2(vector<int> releaseTimes, string keysPressed)
{
    int n = releaseTimes.size();
    int longestPress = releaseTimes[0];
    char slowestKey = keysPressed[0];
    for (int i = 1; i < n; i++)
    {
        int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
        // check if we found the key that is slower than slowestKey
        if (currentDuration > longestPress ||
            (currentDuration == longestPress &&
             keysPressed[i] > slowestKey))
        {
            // update the slowest key and longest press duration
            longestPress = currentDuration;
            slowestKey = keysPressed[i];
        }
    }
    return slowestKey;
}

char slowestKey3(vector<int> releaseTimes, string keysPressed)
{
    int last = 0, maxv = 0;
    char res;
    for (int i = 0; i < keysPressed.size(); ++i)
    {
        int diff = releaseTimes[i] - last;
        if (maxv < diff)
        {
            maxv = diff;
            res = keysPressed[i];
        }
        else if (maxv == diff && res < keysPressed[i])
        {
            res = keysPressed[i];
        }
        last = releaseTimes[i];
    }
    return res;
}

char slowestKey4(vector<int> releaseTimes, string keysPressed)
{
    int durationArray[26] = {0};
    durationArray[keysPressed[0] - 'a'] = releaseTimes[0];
    // find and store the key pressed duration for each key
    for (int i = 1; i < releaseTimes.size(); i++)
    {
        int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
        char currentKey = keysPressed[i];
        durationArray[currentKey - 'a'] =
            max(durationArray[currentKey - 'a'], currentDuration);
    }
    // initialize slowest key as 'z'
    int slowestKeyIndex = 25;
    // iterate from 'y' to 'a' to find slowest key
    for (int currentKey = 24; currentKey >= 0; currentKey--)
    {
        if (durationArray[currentKey] > durationArray[slowestKeyIndex])
        {
            slowestKeyIndex = currentKey;
        }
    }
    return slowestKeyIndex + 'a';
}

int main()
{
    cout << slowestKey({9, 29, 49, 50}, "cbcd") << endl;
    cout << slowestKey({12, 23, 36, 46, 62}, "spuda") << endl;
    cout << slowestKey({23, 34, 43, 59, 62, 80, 83, 92, 97}, "qgkzzihfc") << endl;
    cout << slowestKey({2, 3, 4, 5}, "abbb") << endl;
    cout << slowestKey2({2, 3, 4, 5}, "abbb") << endl;
    cout << slowestKey3({2, 3, 4, 5}, "abbb") << endl;
    cout << slowestKey4({2, 3, 4, 5}, "abbb") << endl;

    return 0;
}