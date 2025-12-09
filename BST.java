public class BST {
    static class Node {
        int data;
        Node left;
        Node rigth;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.rigth = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.rigth = insert(root.rigth, val);
        }
        return root;
    }

    public static boolean peek(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data > val) {
            return peek(root.rigth, val);
        } else if (root.data == val) {
            return true;
        } else {
            return peek(root.rigth, val);
        }
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.rigth);
    }

    public static void main(String[] args) {
        int node[] = { 5, 1, 2, 4, 3, 6 };
        Node root = null;
        for (int i = 0; i < node.length; i++) {
            root = insert(root, node[i]);
        }
        inorder(root);
        System.out.println(peek(root, 7));
    }
}