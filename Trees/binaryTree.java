package Trees;

import java.util.Queue;
import java.util.LinkedList;
public class binaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+" -> ");
        if(root.left!=null) System.out.print(root.left.val+" ");
        if(root.right!=null) System.out.print(root.right.val+" ");
        System.out.println();
        display(root.left);
        display(root.right);
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.println(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static int size(Node root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }
    public static int sumOfNodes(Node root){
        if(root==null) return 0;
        return root.val+sumOfNodes(root.left)+sumOfNodes(root.right);
    }
    public static int productOfNodes(Node root){
        if(root==null) return 1;
        return root.val*productOfNodes(root.left)*productOfNodes(root.right);
    }
    public static int height(Node root){
        if(root==null || root.left==null && root.right==null) return 0;
        return Math.max(1+height(root.left),1+height(root.right));
    }
    public static int maxNode(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(maxNode(root.left),maxNode(root.right)));
    }
    public static void nthLevel1(Node root,int n){
        if(root==null) return;
        if(n==1){
            System.out.print(root.val+" ");
        }
        nthLevel1(root.left, n-1);
        nthLevel1(root.right, n-1);
        return;
    }
    public static void nthLevel2(Node root,int n){
        if(root==null) return;
        if(n==1){
            System.out.print(root.val+" ");
        }
        nthLevel2(root.right, n-1);
        nthLevel2(root.left, n-1);
        return;
    }
    public static void bfs(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            Node temp=q.peek();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.print(temp.val+" ");
            q.remove();
        }
        System.out.println();
    }
        public static void main(String[] args) {
        Node root = new Node(1);
        Node a=new Node(2);
        Node b=new Node(3);
        Node c=new Node(4);
        Node d=new Node(5);
        Node e=new Node(6);
        Node f=new Node(7);
        root.left=a;
        root.right=d;
        a.left=b;
        a.right=c;
        d.right=e;
        d.left=f;
        display(root);
        // preorder(root);
        // System.out.println(size(root));
        // System.out.println(sumOfNodes(root));
        // System.out.println(productOfNodes(root));
        // System.out.println(height(root));
        // System.out.println(maxNode(root));
        int n=height(root)+1;
        for(int i=1; i<=n; i++){
            if(i%2!=0) nthLevel1(root,i);
            else nthLevel2(root,i);
            System.out.println();
        }
        bfs(root);
    }
}
