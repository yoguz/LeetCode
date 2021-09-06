#include <bits/stdc++.h>
using namespace std;

string orderlyQueue(string s, int k)
{
   if (k == 1) {
        string ans = s;
        for (int i = 0; i < s.length(); ++i) {
            string temp = s.substr(i) + s.substr(0, i);
            if (temp < ans) {
                ans = temp;
            }
        }
        return ans;
    } else {
        sort(s.begin(), s.end());
        return s;
    }
}

int main()
{

    cout << orderlyQueue("baacb", 1);
    return 0;
}