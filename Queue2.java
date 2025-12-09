public class Queue2 {
    static int arr[];
    static int size;
    static int head = -1;
    static int tial = -1;

    Queue2(int data) {
        arr = new int[data];
        this.size = data;
    }

    public static boolean isEmpty() {
        return head == -1 && tial == -1;
    }

    public static boolean isFull() {
        return head == (tial + 1) % size;
    }

    public static void add(int data) {
        if (isFull()) {
            System.out.println("Queue is overflow");
            return;
        }
        if (head == -1) {
            head = 0;
        }
        tial = (tial + 1) % size;
        arr[tial] = data;
    }

    public static int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int res = arr[head];
        if (head == tial) {
            head = tial = -1;

        } else {
            head = (head + 1) % size;
        }
        return res;
    }

    public static void main(String[] args) {
        Queue2 q = new Queue2(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        q.add(6);
        q.remove();
        q.add(7);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
