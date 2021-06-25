public class Q211_Design_Add_and_Search_Words_Data_Structure {

    class TrieNode {
        TrieNode[] child;
        boolean isFinal;

        TrieNode(boolean isFinal) {
            child = new TrieNode[26];
            this.isFinal = isFinal;
            for (int i = 0; i < 26; ++i)
                child[i] = null;
        }

        TrieNode() {
            this(false);
        }
    }

    TrieNode head;

    /** Initialize your data structure here. */
    public Q211_Design_Add_and_Search_Words_Data_Structure() {
        head = new TrieNode();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = head, iterator = head;
        for (char c: chars) {
            if (iterator.child[c-'a'] == null) {
                node = new TrieNode();
                iterator.child[c-'a'] = node;
            }
            iterator = iterator.child[c-'a'];
        }

        node.isFinal = true;
    }

    public boolean search(String word) {
        return searchSub(word.toCharArray(), 0, head);
    }

    private boolean searchSub(char[] sub, int idx, TrieNode iterator) {
        if (iterator == null)
            return false;
        else if (idx == sub.length)
            return iterator.isFinal;

        if(sub[idx] == '.') {
            for (int i = 0; i < 26; ++i)
                if (iterator.child[i] != null && searchSub(sub, idx+1, iterator.child[i]))
                    return true;

            return false;
        } else {
            return iterator.child[sub[idx] - 'a'] != null && searchSub(sub, idx+1, iterator.child[sub[idx] - 'a']);

        }
    }

    public static void main(String[] args) {
        Q211_Design_Add_and_Search_Words_Data_Structure obj = new Q211_Design_Add_and_Search_Words_Data_Structure();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
