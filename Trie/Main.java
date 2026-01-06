public class Main{
    public static void main(String[] args) {
        System.out.println("Implementing Trie Data Structure.");

        TrieNode root = new TrieNode();

        String[] words = { "and", "ant", "dad" };
        for (String word : words) {
            root.insert(root, word);
        }

        String[] findWords = { "abc", "and", "ant", "do" };
        for (String word : findWords) {
            System.out.println(root.search(root, word));
        }

        String[] prefixToSearch = { "ab", "nd", "dd", "and", "bc" };
        for (String word : prefixToSearch) {
            System.out.println(root.isPrefix(root, word));
        }
        
        TrieNode r1 = root.remove(root, "abc", 0);
        TrieNode r2 = root.remove(root, "ant", 0);

        System.out.println(r1 + " " + r2);
    }
}