#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> times;

bool bookOn(int start, int end)
{
    for (auto time : times)
    {
        if (max(start, time.first) < min(end, time.second))
            return false;
    }
    times.push_back({start, end});
    return true;
}

set<pair<int, int>> books;

bool book(int s, int e)
{
    auto next = books.lower_bound({s, e}); // first element with key not go before k (i.e., either it is equivalent or goes after).
    if (next != books.end() && next->first < e)
        return false; // a existing book started within the new book (next)
    if (next != books.begin() && s < (--next)->second)
        return false; // new book started within a existing book (prev)
    books.insert({s, e});
    return true;
}

int main()
{
    cout << book(10, 20) << endl;
    cout << book(15, 25) << endl;
    cout << book(20, 30) << endl;
    return 0;
}