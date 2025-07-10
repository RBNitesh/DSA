// Required Java Program to convert an arbitrary binary tree
// to a tree that holds the children's sum property 

// Binary tree node class representation
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    // Function to change the tree to hold the children sum property here
    void convertTree(Node node) {
        
        if (node == null || (node.left == null && node.right == null)) {
            return;
        } 

        int left_data = node.left != null? node.left.data : 0;
        int right_data = node.right != null ? node.right.data : 0;
        
        if(node.data > left_data + right_data){
            if(node.left!=null)
                node.left.data = node.data;
            if(node.right!=null)
                node.right.data = node.data;
        }

        if(node.data < left_data + right_data){
            node.data = left_data + right_data;
        }

        convertTree(node.left);
        convertTree(node.right);

        int node_data = 0;
        if(node.left != null){
            node_data += node.left.data;
        }
        if(node.right != null){
            node_data += node.right.data;
        }
        node.data = node_data;
    }

    // Given a binary tree, print the inorder traversal using the function printInorder()
    void printPreorder(Node node) {
        if (node == null)
            return;
        
        // Then print the data of node
        System.out.print(node.data + " ");

        // First recur on left child
        printPreorder(node.left);

        // Now recur on right child
        printPreorder(node.right);
    }

}

class Main {
    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(48);
        tree.root.left = new Node(9);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(33);
        tree.root.right.right = new Node(2);

        System.out.println("Inorder traversal before conversion is :");
        tree.printPreorder(tree.root);

        tree.convertTree(tree.root);
        System.out.println();

        System.out.println("Inorder traversal after conversion is :");
        tree.printPreorder(tree.root);

    }
}