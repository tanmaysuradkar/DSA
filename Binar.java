import java.util.LinkedList;
import java.util.Queue;

public class Binar {
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

    public static void log(int a) {
        System.err.println(a + " ");
    }

    static class binarTr {
        static int idx = -1;

        public static Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.rigth = buildTree(node);
            return newNode;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        log(root.data);
        preorder(root.left);
        preorder(root.rigth);
    }

    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        Inorder(root.rigth);
        log(root.data);
    }

    public static void Levelorder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.rigth != null) {
                    q.add(currNode.rigth);
                }
            }
        }
    }

    public static void LevelorderKth(Node root, int k) {
        int Kth = 1;
        boolean isNot = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            if (Kth == k) {

                log(q.remove().data);
            }
            Node currNode = q.remove();
            if (currNode == null) {

                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.rigth != null) {
                    q.add(currNode.rigth);
                }
            }
        }
    }

    public static int countOfNode(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countOfNode(root.left);
        int rigth = countOfNode(root.rigth);

        return left + rigth + 1;
    }

    public static int sumOfNode(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countOfNode(root.left);
        int rigth = countOfNode(root.rigth);

        return (left + rigth) + root.data;
    }

    public static int hiegthOfNode(Node root) {
        if (root == null) {
            return 0;
        }
        int left = hiegthOfNode(root.left);
        int rigth = hiegthOfNode(root.rigth);

        return Math.max(left, rigth) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.rigth);
        int diam3 = hiegthOfNode(root.left) + hiegthOfNode(root.rigth) + 1;
        return Math.max(diam3, Math.max(diam1, diam2));
    }

    static class treeInfo {
        int diam;
        int ht;

        treeInfo(int ht, int diam) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static treeInfo diameter2(Node root) {
        if (root == null) {
            return new treeInfo(0, 0);
        }
        treeInfo left = diameter2(root.left);
        treeInfo rigth = diameter2(root.rigth);
        int myHeigth = Math.max(left.ht, rigth.ht) + 1;

        int diam1 = left.diam;
        int diam2 = rigth.diam;
        int diam3 = left.ht + rigth.ht + 1;
        int myDiam = Math.max(Math.max(diam1, diam2), diam3);
        treeInfo Info = new treeInfo(myHeigth, myDiam);
        return Info;
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binarTr tree = new binarTr();
        Node one = tree.buildTree(node);
        // int two = hiegthOfNode(one);
        // int two = diameter2(one).diam;
        LevelorderKth(one, 0);
    }
}
