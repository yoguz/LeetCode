#include <bits/stdc++.h>
using namespace std;

void print_set(set<int> &s)
{
    for (auto& i : s)
    {
        cout << i << " ";
    }
    cout << endl;
}

int main()
{
    set<int> s1{1, 2, 3, 3};
    print_set(s1);

    set<int> s2(s1);
    print_set(s2);

    set<int> s{10,11};
    vector<int> v{1,2,3,4,5};
    s.insert(v.begin(), v.end());
    print_set(s);

    s.insert({100, 101});
    print_set(s);

    s.erase(101);
    print_set(s);

    s.find(5) != s.end() ? cout << "5 found\n" : cout << "5 not found\n";

    return 0;
}