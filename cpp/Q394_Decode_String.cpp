#include <bits/stdc++.h>
using namespace std;

string decodeString(string s)
{
    stack<string> strStack;
    stack<int> numStack;
    int num = 0;
    string str = "";

    for (auto c : s)
    {
        if (isdigit(c))
        {
            num = num * 10 + c - '0';
        }
        else if (c == '[')
        {
            strStack.push(str);
            numStack.push(num);
            str = "";
            num = 0;
        }
        else if (c == ']')
        {
            string decoded = strStack.top();
            strStack.pop();
            int count = numStack.top();
            numStack.pop();
            for (; count > 0; --count)
            {
                decoded += str;
            }
            str = decoded;
        }
        else
        {
            str += c;
        }
    }

    return str;
}

int main()
{
    cout << decodeString("3[a]2[bc]") << "\n";
    cout << decodeString("2[abc]3[cd]ef") << "\n";
    return 0;
}