import java.util.*;

public class CountInversion {
       public static long getInversions(long arr[], int n) {
        // Copy the original array to avoid modifying the input array
        long[] copyArr = Arrays.copyOf(arr, n);

        // Create a temporary array to store the merged subarrays
        long[] temp = new long[n];

        // Perform merge sort and count inversions
        return mergeSortAndCountInversions(copyArr, temp, 0, n - 1);
    }

    private static long mergeSortAndCountInversions(long[] arr, long[] temp, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // Recursive merge sort and count inversions in the left and right subarrays
            count += mergeSortAndCountInversions(arr, temp, left, mid);
            count += mergeSortAndCountInversions(arr, temp, mid + 1, right);

            // Merge the two sorted subarrays and count inversions
            count += mergeAndCountInversions(arr, temp, left, mid, right);
        }

        return count;
    }

    private static long mergeAndCountInversions(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // Inversion detected
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, left, arr, left, right - left + 1);

        return count;
    }

    public static void main(String[] args) {
        // Example usage
        long[] arr = {1, 4, 2, 3, 5};
        int n = arr.length;

        long inversions = getInversions(arr, n);
        System.out.println("Number of inversions: " + inversions);
    }
}
