
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CountSubarray {

    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        Map<Integer, Integer> xorCount = new HashMap<>();
        int xorSum = 0;
        int count = 0;

        xorCount.put(0, 1); // Handle the case of XOR 0 at the beginning

        for (int i = 0; i < arr.size(); i++) {
            xorSum ^= arr.get(i);

            if (xorCount.containsKey(xorSum ^ x)) {
                count += xorCount.get(xorSum ^ x);
            }

            xorCount.put(xorSum, xorCount.getOrDefault(xorSum, 0) + 1);
        }

        return count;
    }
}
