import java.util.*;
public class TrieNode {
    Map<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }

    // insertion
    public void insert(TrieNode root, String key) {
        TrieNode curr = root;

        for (char ch : key.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        
        curr.isEndOfWord = true;
    }

    // searching
    public boolean search(TrieNode root, String key) {
        TrieNode curr = root;

        for (char ch : key.toCharArray()) {
            if (!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }

        return curr.isEndOfWord;
    }

    // prefix searching
    public boolean isPrefix(TrieNode root, String key) {
        TrieNode curr = root;

        for (char ch : key.toCharArray()) {
            if (!curr.children.containsKey(ch))
                return false;
            curr = curr.children.get(ch);
        }

        return true;
    }

    // Return true if root has no childre
    public boolean isEmpty(TrieNode root) {
        return root.children.size() == 0;
    }

    // deleting a key from the trie
    public TrieNode remove(TrieNode root, String key, int depth) {
        if (root == null)
            return null;

        if (depth == key.length()) {
            if (root.isEndOfWord)
                root.isEndOfWord = false;

            // if node has no other children it can be deleted.
            if (isEmpty(root))
                root = null;

            return root;
        }

        char ch = key.charAt(depth);
        TrieNode updatedChild = remove(root.children.get(ch), key, depth + 1);
        
        // if updated child after deleting the key is null, remove the entry for the key.
        if (updatedChild == null) {
            root.children.remove(ch);
        }
        else {
            root.children.put(ch, updatedChild);
        }

        // if this node is not the end of another word and has no children, delete it too.
        if (isEmpty(root) && !root.isEndOfWord) {
            root = null;
        }
        return root;
    }

    // print the words in trie
    public void printWords(TrieNode root) {
        List<String> words = new ArrayList<>();
        storeWords(root, new StringBuilder(), words);
        System.out.println(words);
    }

    // helper function to print the words
    public void storeWords(TrieNode root, StringBuilder sb, List<String> words) {
        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(sb.toString());

        for (Map.Entry<Character, TrieNode> child : root.children.entrySet()) {
            sb.append(child.getKey());
            TrieNode nextNode = child.getValue();
            storeWords(nextNode, sb, words);
            // backtracking
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}