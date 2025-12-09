public class QuickSort {
    public static int partition(int arr[], int low, int high) {
        int pivat = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivat) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivat;
        arr[high] = temp;
        return i;
    }

    public static void quick(int arr[], int low, int high) {
        if (low <= high) {
            int pivo = partition(arr, low, high);
            quick(arr, 0, pivo - 1);
            quick(arr, pivo + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length - 1;
        quick(arr, 0, n);
        for (int index = 0; index <= n; index++) {
            System.out.println(arr[index]);
        }
    }
}
