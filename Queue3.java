public class Queue3 {
    static Node head;
    static Node tial;
    static int size;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isEmpty() {
        return head == null && tial == null;
    }

    public static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tial = newNode;
        } else {
            tial.next = newNode;
            tial = newNode;
        }
    }

    public static int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        if (head == tial) {
            tial = null;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    public static int peak() {
        if (head == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Queue3 q = new Queue3();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peak());
            q.remove();
        }
    }
}
