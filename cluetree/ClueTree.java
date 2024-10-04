package cluetree;

public class ClueTree {
    // Node class representing each node in the binary tree
    private class Node {
        String clue;
        Node left, right;

        public Node(String clue) {
            this.clue = clue;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;  // The root of the binary tree

    // Constructor to initialize an empty tree
    public ClueTree() {
        this.root = null;
    }

    // Insert a new clue into the binary tree
    public void insert(String clue) {
        root = insertRec(root, clue);
    }

    // Recursive helper method to insert a clue into the binary tree
    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }
        return root;
    }

    // Perform in-order traversal (left, root, right)
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Perform pre-order traversal (root, left, right)
    public void preOrderTraversal() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Perform post-order traversal (left, right, root)
    public void postOrderTraversal() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue in the binary tree
    public boolean find(String clue) {
        return findRec(root, clue);
    }

    private boolean findRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (root.clue.equals(clue)) {
            return true;
        }
        if (clue.compareTo(root.clue) < 0) {
            return findRec(root.left, clue);
        }
        return findRec(root.right, clue);
    }

    // Count the total number of clues in the binary tree
    public int countClues() {
        return countRec(root);
    }

    private int countRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countRec(root.left) + countRec(root.right);
    }

    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();

        // Insert clues into the tree
        clueTree.insert("Clue A");
        clueTree.insert("Clue B");
        clueTree.insert("Clue C");
        clueTree.insert("Clue D");

        // Perform tree traversals
        System.out.println("In-order traversal:");
        clueTree.inOrderTraversal();  // Output: Clue A Clue B Clue C Clue D

        System.out.println("\nPre-order traversal:");
        clueTree.preOrderTraversal();  // Output: Clue A Clue B Clue C Clue D

        System.out.println("\nPost-order traversal:");
        clueTree.postOrderTraversal();  // Output: Clue D Clue C Clue B Clue A

        // Find a specific clue
        System.out.println("\nFinding 'Clue B': " + clueTree.find("Clue B"));  // Output: true
        System.out.println("Finding 'Clue Z': " + clueTree.find("Clue Z"));  // Output: false

        // Count the total number of clues
        System.out.println("Total clues in the tree: " + clueTree.countClues());  // Output: 4
    }
}
