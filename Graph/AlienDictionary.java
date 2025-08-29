import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AlienDictionary{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of string array: ");
        int n = sc.nextInt();
        String[] words = new String[n];

        System.out.println("Enter the words: ");
        for(int i=0; i<n; ++i){
            words[i] = sc.next();
        }

        System.out.println("Output: "+findOrder(words));
    }

    public static String findOrder(String[] words) {
        // no. of words in the dictionary
        int n = words.length;
        // adjacency-list representation of graph
        List<Character>[] graph = new ArrayList[26];
        // initialize the graph array with empty list
        for(int i=0; i<26; ++i){
            graph[i] = new ArrayList<>();
        }
        
        // this set contains all the unique chars
        Set<Integer> set = new HashSet<>();
        
        // this array stores the count of the incoming edge for each node
        int[] indegree = new int[26];
        
        String curr = "";
        for(int i=0; i<n; i++){
            String prev = curr;
            curr = words[i];
            
            // add all the unique character in the set
            for(char ch : curr.toCharArray()){
                set.add(ch-'a');
            }
            
            int j = 0;
            while(j < prev.length() && j < curr.length()){
                char ch1 = prev.charAt(j);
                char ch2 = curr.charAt(j);
                
                if(ch1 != ch2){
                    graph[ch1-'a'].add(ch2);
                    
                    // increase the in-degree of the node ch2
                    indegree[ch2-'a']++;
                    break;
                }
                ++j;
            }
            /*  edge case: when curr string is smaller than the 
                prev string and all the char in prev string is also
                present in curr string at index '0' 
                ex: abc ab
            */
            if(j == curr.length() && j < prev.length()) return "";
        }
        
        // Topological sorting using Kahn's algorithm
        
        Queue<Integer> q = new LinkedList<>();
        // initially add all the node which doesn't have any incoming edge (i.e., indegree[node]==0)
        for(int i=0; i<26; ++i){
            if(set.contains(i) && indegree[i]==0){
                q.add(i);
            }
        }
        
        // This strings contains chars of alien dictionary in lexicographical oreder
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append((char)('a'+node));
            
            for(int i=0; i<graph[node].size(); ++i){
                int adjacent = graph[node].get(i)-'a';
                
                if(--indegree[adjacent]==0){
                    q.add(adjacent);
                }
            }
        }
        
        return sb.length()==set.size()? sb.toString() : "";
    }
}