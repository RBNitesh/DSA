package Trees;

public class BST {
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
        System.out.print(root.val+" ");
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
    public static void insert(Node root,int val){
        Node node=new Node(val);
        if(root==null) root=node;
        if(val < root.val){
            if(root.left==null) root.left=node;
            else insert(root.left, val);
        }else{
            if(root.right==null) root.right=node;
            else insert(root.right, val);
        }
        return;
    }

    public static void main(String[] args) {
        Node root=new Node(15);
        insert(root,5);
        insert(root, 25);
        insert(root,3);
        insert(root, 10);
        insert(root,20);
        insert(root, 30);
        insert(root,2);
        insert(root, 4);
        display(root);
        preorder(root);
        System.out.println();
        System.out.println(size(root));
        System.out.println(sumOfNodes(root));
        System.out.println(productOfNodes(root));
        System.out.println(height(root));
        System.out.println(maxNode(root));
    }
}
