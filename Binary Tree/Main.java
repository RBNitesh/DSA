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
        int left_data = 0, right_data = 0, diff;

        // If the leaf node or the tree is empty then return true here
        if (node == null || (node.left == null && node.right == null)) {
            return;
        } else {
            // Convert the left and the right subtrees
            convertTree(node.left);
            convertTree(node.right);

            // If the left child is not present then 0 is used as data for the left child
            if (node.left != null) {
                left_data = node.left.data;
            }

            // If the right child is not present in the tree then 0 is used as data value of right child in the tree
            if (node.right != null) {
                right_data = node.right.data;
            }

            // Get the diff value  of the node's data and children sum
            diff = left_data + right_data - node.data;

            // If a node's children sum is greater than the node's data
            if (diff > 0) {
                node.data = node.data + diff;
            }

            // If node's data value is greater than the children's sum, then increment subtree by diff
            if (diff < 0)
                // -diff is used to make diff positive
                increment(node, -diff);
        }
    }

    // Function to increment subtree by diff
    void increment(Node node, int diff) {
        // IF left child is not NULL then increment it
        if (node.left != null) {
            node.left.data = node.left.data + diff;

            // Recursively call to fix the descendants of node->left
            increment(node.left, diff);
        } else if (node.right != null) // Else increment right child
        {
            node.right.data = node.right.data + diff;
            // Recursively call to fix the descendants of node->right
            increment(node.right, diff);
        }
    }

    // Given a binary tree, print the inorder traversal using the function printInorder()
    void printInorder(Node node) {
        if (node == null)
            return;

        // First recur on left child
        printInorder(node.left);

        // Then print the data of node
        System.out.print(node.data + " ");

        // Now recur on right child
        printInorder(node.right);
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
        tree.printInorder(tree.root);

        tree.convertTree(tree.root);
        System.out.println("");

        System.out.println("Inorder traversal after conversion is :");
        tree.printInorder(tree.root);

    }
}