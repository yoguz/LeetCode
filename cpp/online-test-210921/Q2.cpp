#include <bits/stdc++.h>
using namespace std;

// 4/6 Correctness Passed 4/4 Performance Passed
int solution(vector<int> A) {
    A.push_back(A[0]);

    int n = A.size();
    vector<int> dp(n, 0);
    dp[1] = (A[0] + A[1] + 1) % 2;
    for (size_t i = 2; i < n; ++i) {
        dp[i] = max(dp[i-1], dp[i-2]+(A[i] + A[i-1] + 1)%2);
    }

    return dp[0] == dp[1] ? dp[n-1] : dp[n-2];
}

int main() {
   cout << solution({4,2,5,8,7,3,8}) << "\n";
   cout << solution({1}) << "\n";
   cout << solution({1, 1}) << "\n";
   cout << solution({2}) << "\n";
   cout << solution({1, 2}) << "\n";
   cout << solution({2,2,2}) << "\n";
}