#include <bits/stdc++.h>
using namespace std;

int helper(vector<int> &nums, int target, int lo, int hi)
{
    if (lo > hi)
        return -1;

    int mid = (hi - lo) / 2 + lo;
    if (nums[mid] == target)
        return mid;
    else if (nums[mid] < target)
        return helper(nums, target, mid + 1, hi);
    else
        return helper(nums, target, lo, mid - 1);
}

int search(vector<int> &nums, int target)
{
    return helper(nums, target, 0, nums.size());
}

int main()
{
    vector<int> numbers{-1,0,3,5,9,12};
    cout << search(numbers, 9) << endl;
    cout << search(numbers, 2) << endl;
}