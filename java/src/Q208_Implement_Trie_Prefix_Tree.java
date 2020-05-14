public class Q208_Implement_Trie_Prefix_Tree {

    class Trie {

        class TrieNode {

            static final int ALPHABET_SIZE = 26;

            TrieNode[] children;
            boolean isEnd;

            TrieNode(boolean isEnd) { this(); this.isEnd = isEnd;}
            TrieNode() { children = new TrieNode[26]; }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(false );
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length() - 1; ++i) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TrieNode(false);
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            if (node.children[word.charAt(word.length()-1) - 'a'] == null) {
                node.children[word.charAt(word.length()-1) - 'a'] = new TrieNode(true);
            } else {
                node.children[word.charAt(word.length()-1) - 'a'].isEnd = true;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length() - 1; ++i) {
                if (node.children[word.charAt(i) - 'a'] == null)
                    return false;
                node = node.children[word.charAt(i) - 'a'];
            }

            return node.children[word.charAt(word.length() - 1) - 'a'] != null && node.children[word.charAt(word.length() - 1) - 'a'].isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); ++i) {
                if (node.children[prefix.charAt(i) - 'a'] == null)
                    return false;
                node = node.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Q208_Implement_Trie_Prefix_Tree.Trie obj = new Q208_Implement_Trie_Prefix_Tree().new Trie();
        obj.insert("hello");
        obj.insert("hellos");


        obj.insert("hello");
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("helloa"));
        System.out.println(obj.search("hello"));
        System.out.println(obj.startsWith("hell"));
        System.out.println(obj.startsWith("helloa"));
        System.out.println(obj.startsWith("hello"));

    }
}
