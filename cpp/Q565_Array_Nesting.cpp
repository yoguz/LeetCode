#include <bits/stdc++.h>
using namespace std;

int arrayNesting(vector<int> &a)
{
    size_t maxsize = 0;
    for (int i = 0; i < a.size(); i++)
    {
        size_t size = 0;
        for (int k = i; a[k] >= 0; size++)
        {
            int ak = a[k];
            a[k] = -1; // mark a[k] as visited;
            k = ak;
        }
        maxsize = max(maxsize, size);
    }

    return maxsize;
}

int main()
{
    vector<int> vec1{5, 4, 0, 3, 1, 6, 2};
    cout << arrayNesting(vec1) << endl;

    vector<int> vec2{0, 1, 2};
    cout << arrayNesting(vec2) << endl;

    vector<int> vec3{0, 2, 1};
    cout << arrayNesting(vec3) << endl;
    return 0;
}