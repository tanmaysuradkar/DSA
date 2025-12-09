import java.util.ArrayList;
import java.util.HashMap;

public class hashmapQ1 {
    public static void MajorityElement(int nums[]) {
        int freq = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], (map.get(nums[i]) + 1));
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int keys : map.keySet()) {
            if (map.get(keys) > freq) {
                System.out.println(keys + " Majority Element " + map.get(keys));
            }
        }
    }

    public static void main(String[] arge) {
        int nums[] = { 1, 5, 5, 1, 1, 3, 3, 2 };
        MajorityElement(nums);
    }
}
