#include <bits/stdc++.h>
using namespace std;

// 5/5 Correctness Passed 4/4 Performance Passed
int solution(vector<int> A) {
    vector<int> counts(5, 0);
    int total = 0;
    for (auto num: A) {
        counts[num]++;
        total++;
    }
    int medIdx = total/2;
    int median = 1;
    for (size_t i = 1; i < counts.size(); ++i) {
        medIdx -= counts[i];
        if (medIdx < 0) {
            median = i;
            break;
        }
    }

    int res = 0;
    for (int i = 1; i < counts.size(); ++i) {
        res += abs(i - median) * counts[i];
    }
    return res;
}

int main() {
    cout << solution({4,1,4,1}) << "\n";
    cout << solution({3, 2, 1, 1, 2, 3, 1}) << "\n";
   return 0;

}