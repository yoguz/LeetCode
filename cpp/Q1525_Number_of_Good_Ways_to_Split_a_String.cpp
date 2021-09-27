#include <bits/stdc++.h>
using namespace std;

int numSplits(string s) {
        map<char, int> left, right;
        for (auto &c: s) {
            right[c] += 1;
        }
        
        int res = 0;
        for (auto &c: s) {
            right[c]--;
            left[c] += 1;
            if (right[c] == 0)
                right.erase(right.find(c));
            
            if (right.size() == left.size())
                res++;
        }
        
        return res;
    }

int main() {
   
}