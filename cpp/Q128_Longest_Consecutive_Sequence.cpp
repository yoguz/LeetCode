#include <bits/stdc++.h>
using namespace std;

int longestConsecutive(vector<int> &nums)
{
    unordered_set<int> numberSet;
    for (int num : nums)
    {
        numberSet.insert(num);
    }

    unordered_set<int>::iterator it = numberSet.begin();
    int maxSeq = 0, seq = 0, number = 0;
    while (it != numberSet.end())
    {
        seq = 0;
        number = *it;
        if (numberSet.find(*it - 1) == numberSet.end())
        {
            while (it != numberSet.end() && numberSet.find(number++) != numberSet.end())
            {
                seq++;
            }
        }

        maxSeq = max(maxSeq, seq);
        ++it;
    }

    return maxSeq;
}

int main()
{
    vector<int> numbers1{100, 4, 200, 1, 3, 2};
    cout << longestConsecutive(numbers1) << endl;

    vector<int> numbers2{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    cout << longestConsecutive(numbers2) << endl;

    return 0;
}