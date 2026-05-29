import java.util.*;

class Node{
    Node[] children;
    int cnt, freq;
  
    public Node() {
      children = new Node[2];
    }
    
    public void insert(Node root, int n) {
        Node curr = root;
        curr.freq++;
        for (int i = 31; i >= 0; i--) {
            int d = n & (1 << i);
            d = (d == 0) ? 0 : 1;
            if (curr.children[d] == null) {
                curr.children[d] = new Node();
            }
            curr = curr.children[d];
            curr.freq++;
        }
        curr.cnt++;
    }
  
    public int maxXorPair(Node root, int n) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
          int d = n & (1 << i);
          d = (d == 0) ? 0 : 1;
          if (curr.children[d^1] != null) {
            // set the k-th bit
            ans |= (1 << i);
            curr = curr.children[d ^ 1];
          } else {
            curr = curr.children[d];
          }
        }
        return ans;
    }
  }