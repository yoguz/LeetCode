#include <bits/stdc++.h>
using namespace std;

vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> ans;
        int begin = 0;
        while (begin < words.size()) {
            int last = begin;
            int linesize = words[begin++].size();
            while (begin < words.size() && linesize + 1 + words[begin].size() <= L) {
                linesize += 1 + words[begin++].size();
            }
            
            int spaces = 1, extra = 0;
            if (begin < words.size() && begin != last + 1) {
                spaces = (L - linesize) / (begin - last - 1) + 1;
                extra = (L - linesize) % (begin - last - 1);
            }
            
            ans.push_back(words[last++]);
            while (extra--) {
                ans.back().append(spaces+1, ' ');
                ans.back().append(words[last++]);
            }
            while (last < begin) {
                ans.back().append(spaces, ' ');
                ans.back().append(words[last++]);
            }
            ans.back().append(L-ans.back().size(), ' ');
        }
        
        return ans;
    }

int main()
{
    vector<string> words1{"This", "is", "an", "example", "of", "text", "justification."};
    vector<string> res1 = fullJustify(words1, 16);
    for (string line: res1)
        cout << line << endl;

    cout << endl;

    vector<string> words2{"What","must","be","acknowledgment","shall","be"};
    vector<string> res2 = fullJustify(words2, 16);
    for (string line: res2)
        cout << line << endl;

    cout << endl;

    vector<string> words3{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
    vector<string> res3 = fullJustify(words3, 20);
    for (string line: res3)
        cout << line << endl;

    cout << endl;

    vector<string> words4{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
    vector<string> res4 = fullJustify(words4, 16);
    for (string line: res4)
        cout << line << endl;

    cout << endl;

    return 0;
}