import java.util.HashMap;

public class hashMapQ3 {
    public static String Strating(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);

        }
        for (String key : map.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Bangaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");
        String keyStarting = Strating(map);

        while (map.containsKey(keyStarting)) {
            System.out.print(keyStarting + " --> ");
            keyStarting = map.get(keyStarting);
        }
        System.out.println(keyStarting);
    }
}
