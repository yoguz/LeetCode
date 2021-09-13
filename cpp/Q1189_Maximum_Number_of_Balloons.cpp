#include <bits/stdc++.h>
using namespace std;

int maxNumberOfBalloons(string text)
{
    int count[26]{0};
    for (size_t i = 0; i < text.length(); ++i)
    {
        count[text[i] - 'a']++;
    }

    return min({count['b' - 'a'], count['a' - 'a'], count['n' - 'a'], count['l' - 'a'] / 2, count['o' - 'a'] / 2});
}

int main()
{
    cout << maxNumberOfBalloons("nlaebolko");
    return 0;
}
