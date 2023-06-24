import java.util.Arrays;

public class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort the stalls array in ascending order

        int n = stalls.length;
        int left = 1; // Minimum possible distance between cows
        int right = stalls[n - 1] - stalls[0]; // Maximum possible distance between cows
        int maxDistance = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                maxDistance = mid;
                left = mid + 1; // Try to increase the distance
            } else {
                right = mid - 1; // Try to decrease the distance
            }
        }

        return maxDistance;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int distance) {
        int cowsPlaced = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                cowsPlaced++;
                lastPosition = stalls[i];

                if (cowsPlaced == k) {
                    return true; // All cows have been placed
                }
            }
        }

        return false; // Unable to place all cows
    }
}
