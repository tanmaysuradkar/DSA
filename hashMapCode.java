import java.util.ArrayList;
import java.util.LinkedList;

public class hashMapCode {
    static class HashMap<K, V> {
        // K, V, constution, n, N, bucket,
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // size of Node
        private int N; // size of bucket
        private LinkedList<Node> bucket[];

        // hashmap function for create hashmap story
        public HashMap() {
            this.N = 4;
            this.bucket = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        // Search with bucket index, key
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = bucket[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        // hash function with key
        private int hashfunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Rehash
        private void rehash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                bucket[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // Put, get, containKey, remove, keySet, isEmpty
        public void put(K key, V value) {
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) { // Key is doesn't exist
                bucket[bi].add(new Node(key, value));
                n++;
            } else { // Key is exist
                Node node = bucket[bi].get(di);
                node.value = value;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containKey(K key) {
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {// key is doesn't exist
                return false;
            } else {// key is exist
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) { // key is doesn't exist
                return null;
            } else { // key is exist
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = hashfunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) { // key is doesn't exist
                return null;
            } else {
                Node node = bucket[bi].get(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tanmay", 0);
        map.put("Rahul", 1800);
        map.put("Shital", 35000);
        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }
    }
}