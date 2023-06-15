
    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepeatMissing {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] result = new int[2];
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count the frequency of each number in the array
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the missing number and the repeating number
        for (int i = 1; i <= n; i++) {
            if (!countMap.containsKey(i)) {
                result[0] = i; // Missing number
            } else if (countMap.get(i) > 1) {
                result[1] = i; // Repeating number
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(4);
        arr.add(5);

        int n = 5;

        int[] result = missingAndRepeating(arr, n);
        System.out.println("Missing number: " + result[0]);
        System.out.println("Repeating number: " + result[1]);
    }
}

