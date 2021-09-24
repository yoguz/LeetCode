#include <bits/stdc++.h>
using namespace std;

// 5/5 Correctness Passed 5/5 Performance Passed
struct edge {
    int num;
    unordered_set<int> neighbors;

    edge() {
        num = 0;
    }
};

int solution(int N, vector<int> A, vector<int> B) {
    vector<edge > edges(N+1);

    for (size_t i = 0; i < A.size(); ++i) {
        edges[A[i]].num = A[i];
        edges[A[i]].neighbors.insert(B[i]);
        edges[B[i]].num = B[i];
        edges[B[i]].neighbors.insert(A[i]);
    }

    std::sort(edges.begin(), edges.end(), [](auto & a, auto & b){ return a.neighbors.size() > b.neighbors.size(); });

    int res = 0;
    for (size_t i = 0; i <= N; ++i) {
        res += (N-i) * edges[i].neighbors.size();
    }

    return res;
}

int main() {
   cout << solution(5, {2,2,1,2}, {1,3,4,4}) << "\n";
   cout << solution(3, {1}, {3}) << "\n";
   cout << solution(4, {1,3}, {2,4}) << "\n";
   return 0;
}