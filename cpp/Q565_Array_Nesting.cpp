#include <bits/stdc++.h>
using namespace std;

int arrayNesting(vector<int> &nums)
{
    int maxCount = 0;

    for (size_t i = 0; i < nums.size(); ++i)
    {
        int count = 0;

        for (size_t k = i; nums[k] != -1; ++count)
        {
            int temp = nums[k];
            nums[k] = -1;
            k = temp;
        }

        maxCount = max(maxCount, count);
    }

    return maxCount;
}

int main()
{
    vector<int> vec1{5, 4, 0, 3, 1, 6, 2};
    cout << arrayNesting(vec1) << endl;

    vector<int> vec2{0, 1, 2};
    cout << arrayNesting(vec2) << endl;

    vector<int> vec3{0, 2, 1};
    cout << arrayNesting(vec3) << endl;

    return 0;
}