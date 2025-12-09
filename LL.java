class LL {
    Node head;
    int size = 0;
    Node tial;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addlast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tial = newNode;
            size++;
            return;
        }
        tial.next = newNode;
        tial = newNode;
        size++;
    }

    // public Node reverseRecursive(Node head) {
    // if (head == null || head.next == null) {
    // return head;
    // }
    // Node newHeaNode = reverseRecursive(head.next);
    // head.next.next = head;
    // head.next = null;
    // return newHeaNode;
    // }
    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {

            Node nextNode = currNode.next;
            System.out.println("prevNode  " + prevNode.data);
            System.out.println("currNode  " + currNode.data);
            System.out.println("nextNode  " + nextNode.data);
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;

        }
        head.next = null;
        head = prevNode;
    }

    public int getsize() {
        return size;
    }

    public void printt() {
        if (head == null) {
            System.out.println("tanmay");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
        System.out.println(currNode.data);
    }

    public static void main(String[] args) {
        LL news = new LL();
        news.addlast(1);
        news.addlast(2);
        news.addlast(3);
        news.addlast(4);
        news.reverseList();
        System.out.println("size LL " + news.getsize());
        news.printt();
    }
}