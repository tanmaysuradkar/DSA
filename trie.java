public class trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) {
                return false;
            }
            if (i == key.length() - 1 && node.eow == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean startwith(String prifix) {
        Node curr = root;
        for (int i = 0; i < prifix.length(); i++) {
            int idx = prifix.charAt(i) - 'a';
            Node node = curr.children[idx];
            if (node == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean wordBreak(String keys) {
        if (keys.length() == 0) {
            return true;
        }
        for (int i = 1; i <= keys.length(); i++) {
            String firstPart = keys.substring(0, i);
            String secoPart = keys.substring(i);
            if (search(firstPart) && wordBreak(secoPart)) {
                return true;
            }
        }
        return false;
    }

    public static int NodeCount(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += NodeCount(root.children[i]);
        }
        return count + 1;
    }

    public static String ans = "";

    public static void logestpath(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                logestpath(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String word2[] = { "a", "banana", "app", "appl", "ap", "apple" };
        String word[] = { "i", "like", "sam", "samsung", "ice" };
        String keys = "ilikesamsung";
        String suffix = "apple";
        for (int i = 0; i < word2.length; i++) {
            insert(word2[i]);
        }
        logestpath(root, new StringBuilder(""));
        System.out.println(ans);
    }
}