public class TrieNode {
    TrieNode[] children;
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

    // Return true if root has no childre
    public boolean isEmpty(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
                return false;
        }
        return true;
    }

    // deleting a key from the trie
    public TrieNode remove(TrieNode root, String key, int depth) {
        if (root == null)
            return null;

        if (depth == key.length()) {
            root.isEndOfWord = false;

            if (isEmpty(root))
                root = null;

            return root;
        }

        int idx = key.charAt(depth) - 'a';
        root.children[idx] = remove(root.children[idx], key, depth + 1);

        if (isEmpty(root) && root.isEndOfWord) {
            root = null;
        }
        return root;
    }
}