import java.util.ArrayList;

public class Stack {
    static ArrayList<Integer> s = new ArrayList<>();

    static class StackLL {
        public boolean isEmpty() {
            return s.isEmpty();
        }

        public void push(int data) {
            s.add(data);
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = s.get(s.size() - 1);
            s.remove(s.size() - 1);
            return top;
        }

        public void printtt() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.println(s.toString());
        }

        public int peak() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            System.out.println(s.get(s.size() - 1));
            return s.get(s.size() - 1);
        }

        public void pushAtButton(int data, StackLL s) {
            if (isEmpty()) {
                s.push(data);
                return;
            }
            int top = s.pop();
            pushAtButton(data, s);
            s.push(top);
        }

        public void reverse(StackLL s) {
            if (isEmpty()) {
                return;
            }
            int top = s.pop();
            reverse(s);
            s.pushAtButton(top, s);
        }
    }

    public static void main(String[] args) {
        StackLL s = new StackLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.reverse(s);
        while (!s.isEmpty()) {
            s.peak();
            int top = s.pop();
            System.out.println(top);
        }
    }
}
