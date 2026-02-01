import java.util.*;

class Solution {
    public int minimumWordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        int res = solve(s.length(), s, words);
        return res >= s.length() ? -1 : res;
    }

    public int solve(int n, String s, Set<String> words) {
        if (words.contains(s.substring(0, n)) || n == 0) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;
        for (int idx = n - 1; idx >= 0; idx--) {
            if (words.contains(s.substring(idx, n))) {
                mini = Math.min(mini, 1 + solve(idx, s, words));
            }
        }
        return mini;
    }
}

public class WordBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> wordDict = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            wordDict.add(sc.next());
        }

        Solution obj = new Solution();
        System.out.println(obj.minimumWordBreak(s, wordDict));
    }
}