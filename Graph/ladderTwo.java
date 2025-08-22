import java.util.*;
public class ladderTwo{
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";

        findLadders(beginWord, endWord, wordList);
    }

    public static void findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        List<List<String>> res = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(wordList.get(i));
        }

        Queue<List<String>> q = new LinkedList<>();
        List<String> st = new ArrayList<>();
        st.add(beginWord);
        q.add(st);

        boolean flag = false;
        while(!q.isEmpty()){
            int N = q.size();

            for(int k=0; k<N; k++){
                List<String> lt = q.poll();
                String last_word = lt.get(lt.size()-1);
                set.remove(last_word);
                
                if(last_word.equals(endWord)){
                    if(res.size()==0) res.add(lt);
                    else{
                        if(res.get(0).size()==lt.size()) res.add(lt);
                    }
                }

                for(int i=0; i<last_word.length(); i++){
                    StringBuilder sb = new StringBuilder(last_word);
                    for(char ch='a'; ch<='z'; ch++){
                        sb.setCharAt(i, ch);

                        if(set.contains(sb.toString())){
                            List<String> list = new ArrayList<>(lt);
                            list.add(sb.toString());
                            q.add(list);
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }
}