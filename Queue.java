public class Queue {
    static int arr[];
    static int size;
    static int rear = -1;

    Queue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public static boolean isEmpty() {
        return rear == -1;
    }

    static void add(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full update the size of Queue");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    public static int pop() {
        if (isEmpty()) {
            return -1;
        }
        int data = arr[0];
        for (var i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return data;
    }

    public static int peak() {
        if (isEmpty()) {
            return -1;
        }
        int data = arr[0];
        System.out.println(data);
        return data;
    }

    public static void main(String[] args) {
        Queue s = new Queue(5);
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        while (!s.isEmpty()) {
            s.peak();
            s.pop();
        }
    }
}
