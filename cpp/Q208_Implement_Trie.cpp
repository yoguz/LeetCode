#include <bits/stdc++.h>
using namespace std;

#define ALPHABET_SIZE 26

class TrieNode
{
public:
    TrieNode(bool isFinal = false)
    {
        this->isFinal = isFinal;
    }

    bool isFinal;
    TrieNode *suffixes[ALPHABET_SIZE]{0};
};

class Trie
{
public:
    /** Initialize your data structure here. */
    Trie()
    {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    void insert(string word)
    {
        int idx = 0;
        TrieNode *it = root;
        while (idx < word.length() && it->suffixes[word[idx] - 'a'] != 0)
        {
            it = it->suffixes[word[idx] - 'a'];
            idx++;
        }

        for (; idx < word.length(); ++idx) 
        {
            it->suffixes[word[idx] - 'a'] = new TrieNode();
            it = it->suffixes[word[idx] - 'a'];
        }

        it->isFinal = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word)
    {
        int idx = 0;
        TrieNode *it = root;
        while (idx < word.length() && it->suffixes[word[idx] - 'a'] != 0)
        {
            it = it->suffixes[word[idx] - 'a'];
            idx++;
        }

        return idx == word.length() && it->isFinal;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix)
    {
        int idx = 0;
        TrieNode *it = root;
        while (idx < prefix.length() && it->suffixes[prefix[idx] - 'a'] != 0)
        {
            it = it->suffixes[prefix[idx] - 'a'];
            idx++;
        }

        return idx == prefix.length();
    }

private:
    TrieNode *root;
};

int main()
{
    Trie *obj = new Trie();
    obj->insert("apple");
    cout << obj->search("apple") << endl;
    cout << obj->search("app") << endl;
    cout << obj->startsWith("app") << endl;
    obj->insert("app");
    cout << obj->search("app") << endl;

    return 0;
}