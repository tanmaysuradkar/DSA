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
                System.out.println(curr.children[idx] + " " + idx);
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

    public static void main(String[] args) {
        String word[] = { "i", "like", "sam", "sung", "ice" };
        String keys = "ilikesamsung";
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        System.out.println(wordBreak(keys));
        System.out.println(search("i"));
        System.out.println(search("like"));
        System.out.println(search("sam"));
        System.out.println(search("sung"));
    }
}
