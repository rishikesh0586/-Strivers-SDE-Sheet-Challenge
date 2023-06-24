public class Solution {
    public static double median(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        // Ensure the first array (a) is always smaller or equal in size compared to the second array (b)
        if (m > n) {
            int[] tempArr = a;
            a = b;
            b = tempArr;
            int tempLen = m;
            m = n;
            n = tempLen;
        }

        int leftPartitionSize = (m + n + 1) / 2; // Size of the left partition after combining both arrays

        int minIndex = 0;
        int maxIndex = m;

        while (minIndex <= maxIndex) {
            int i = (minIndex + maxIndex) / 2; // Partition index for the first array
            int j = leftPartitionSize - i; // Partition index for the second array

            // Binary search partition condition
            if (i < m && b[j - 1] > a[i]) {
                minIndex = i + 1; // Move to the right half of the first array
            } else if (i > 0 && a[i - 1] > b[j]) {
                maxIndex = i - 1; // Move to the left half of the first array
            } else {
                // Found the correct partition indices

                int maxLeft; // Maximum element of the left partition
                if (i == 0) {
                    maxLeft = b[j - 1];
                } else if (j == 0) {
                    maxLeft = a[i - 1];
                } else {
                    maxLeft = Math.max(a[i - 1], b[j - 1]);
                }

                // If the combined length of both arrays is odd, return the maxLeft as the median
                if ((m + n) % 2 != 0) {
                    return maxLeft;
                }

                int minRight; // Minimum element of the right partition
                if (i == m) {
                    minRight = b[j];
                } else if (j == n) {
                    minRight = a[i];
                } else {
                    minRight = Math.min(a[i], b[j]);
                }

                // If the combined length of both arrays is even, return the average of maxLeft and minRight as the median
                return (maxLeft + minRight) / 2.0;
            }
        }

        // Arrays are not sorted or some other error occurred
        throw new IllegalArgumentException("Arrays are not sorted or invalid input");
    }
}
