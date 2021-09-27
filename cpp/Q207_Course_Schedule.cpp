#include <bits/stdc++.h>
using namespace std;

bool canFinish(int numCourses, vector<vector<int>> &&prerequisites)
{
    unordered_map<int, vector<int>> pres;
    for (vector<int> &pre : prerequisites)
    {
        pres[pre[0]].push_back(pre[1]);
    }

    unordered_set<int> searched;

    for (auto &key : pres)
    {
        if (searched.find(key.first) != searched.end())
            continue;

        unordered_set<int> visited;
        stack<int> dfs;
        dfs.push(key.first);
        while (!dfs.empty())
        {
            int node = dfs.top();
            dfs.pop();
            if (visited.find(node) != visited.end())
                return false;

            visited.insert(node);
            searched.insert(node);

            for (int pre : pres[node])
            {
                dfs.push(pre);
            }
        }
    }

    return true;
}

int main()
{
    cout << std::boolalpha << canFinish(5, {{1,4}, {2,4}, {3,1}, {3,2}}) << "\n";

}