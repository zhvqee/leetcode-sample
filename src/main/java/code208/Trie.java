package code208;

public class Trie {

    class TrieNode {

        TrieNode[] nodes;

        boolean isWord;

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }
    }

    private TrieNode dummy;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        dummy = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = dummy;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.nodes[ch - 'a'] == null) {
                p.nodes[ch - 'a'] = new TrieNode();
            }
            p = p.nodes[ch - 'a'];
        }
        p.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = dummy;
        if (p == null) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode trieNode = p.nodes[ch - 'a'];
            if (trieNode == null) {
                return false;
            }
            p = trieNode;
        }
        return p.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = dummy;
        if (p == null) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode trieNode = p.nodes[ch - 'a'];
            if (trieNode == null) {
                return false;
            }
            p = trieNode;
        }
        return true;
    }

    public static void main(String[] args) {
        //["Trie","insert","search","search","startsWith","insert","search"]
        //[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
        // 预期：[null,null,true,false,true,null,true]
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True


    }
}