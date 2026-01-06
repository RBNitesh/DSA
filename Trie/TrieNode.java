public class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }

    // insertion
    public void insert(TrieNode root, String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (curr.children[ch - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.children[ch - 'a'] = new TrieNode();
            }

            curr = curr.children[ch - 'a'];
        }
        curr.isEndOfWord = true;
    }

    // searching
    public boolean search(TrieNode root, String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (curr.children[ch - 'a'] == null)
                return false;

            curr = curr.children[ch - 'a'];
        }

        return curr.isEndOfWord;
    }
    // prefix searching
    public boolean isPrefix(TrieNode root, String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (curr.children[ch - 'a'] == null)
                return false;

            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}