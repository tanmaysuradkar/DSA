public class merged {
    public static void conquer(int[] arr, int start, int mid, int end) {

        int merged[] = new int[end - start + 1];
        int idx1 = start;// 0
        int idx2 = mid + 1;// 2
        int x = 0;// 1
        // start = 0 ,mid = 1,end = 2
        // 6 ,3, 9, 5 2 8
        // 3 , 6 , 9 , 5 , 2 , 8
        System.out.println("Conquer start " + start + " mid " + mid + " end " + end);
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= end) {
            merged[x++] = arr[idx2++];
        }
        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void mergeNum(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        // start = 0, mid = 2, end = 2
        int mid = start + (end - start) / 2;// 6 ,3, 9, 5 2 8
        System.out.println("Merge start " + start + " mid " + mid + " end " + end);
        mergeNum(arr, start, mid);
        mergeNum(arr, mid + 1, end);
        conquer(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length - 1;
        mergeNum(arr, 0, n);
        for (int index = 0; index <= n; index++) {
            System.out.println(arr[index]);
        }
    }
}
