public class backtracking {
    public static void countOfNumber(int x, int y, int z) {
        if (x >= y) {
            return;
        }
        z *= y;
        System.out.println("z =" + z + " " + "y =" + y + " " + "x =" + x);
        x++;
        countOfNumber(x, y, z);
    }

    public static void main(String[] args) {
        int x = 0;
        int y = 10;
        int z = 1;
        countOfNumber(x, y, z);
        System.out.println(z);
    }
}
