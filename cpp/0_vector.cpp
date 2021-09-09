#include <bits/stdc++.h>
using namespace std;

void print_vec(vector<int> &v)
{
    for (size_t i = 0; i < v.size(); ++i)
    {
        cout << v[i] << " ";
    }
    cout << endl;
}

int main()
{
    vector<int> v1(5);
    print_vec(v1);

    vector<int> v2(5, 100);
    print_vec(v2);

    vector<int> v3{5};
    print_vec(v3);

    vector<int> v4(v2);
    print_vec(v4);

    vector<int> v{1,2,3,4,5};
    cout << "front:" << v.front() << ", back:" << v.back() << endl;

    cout << "empty:" << v.empty() << endl;

    auto it = v.begin();
    it = v.insert(it, 0);
    print_vec(v);

    it = v.erase(v.begin(), v.begin() + 2);
    print_vec(v);

    v.insert(it, 2, 3);
    print_vec(v);

    vector<int> v5{10,11,12};
    v.swap(v5);
    print_vec(v);

    v.pop_back();
    print_vec(v);

    v.push_back(20);
    print_vec(v);

    return 0;
}