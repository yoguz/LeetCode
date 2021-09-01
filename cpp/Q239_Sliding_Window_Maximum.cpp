#include <bits/stdc++.h>
using namespace std;

// g++ -std=c++11 -O2 -Wall test.cpp -o test

vector<int> maxSlidingWindow(vector<int> &nums, int k)
{
    deque<int> dq;
    vector<int> ans;
    for (int i = 0; i < nums.size(); i++)
    {
        if (!dq.empty() && dq.back() == i - k) // Outside of window
            dq.pop_back();

        while (!dq.empty() && nums[dq.front()] < nums[i]) // smaller than the new number
            dq.pop_front();

        dq.push_front(i);

        if (i >= k - 1)
            ans.push_back(nums[dq.back()]);
    }
    return ans;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> nums = {1,5,2,6,8,2,67,98,7,43};
    vector<int> res = maxSlidingWindow(nums, 3);
    for (int i: res)
        cout << i << ", ";
    cout << endl;

    nums = {10,9,8,7,6,5,4,3,2,1};
    res = maxSlidingWindow(nums, 3);
    for (int i: res)
        cout << i << ", ";
    cout << endl;
}