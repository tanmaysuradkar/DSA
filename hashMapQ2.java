import java.util.HashSet;

public class hashMapQ2 {
    public static int UnionOf2Array(int nums1[], int nums2[]) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                count++;
                System.out.print(nums2[j] + " ");
                set.remove(nums2[j]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int nums1[] = { 7, 3, 9 };
        int nums2[] = { 6, 3, 9, 6, 2, 4 };
        System.out.println(UnionOf2Array(nums1, nums2));

    }
}
