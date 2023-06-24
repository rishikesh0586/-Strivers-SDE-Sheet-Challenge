public class Solution {
    public static int NthRoot(int n, int m) {

//  try {
//             int result = Solution.NthRoot(n, m);
//             System.out.println(result);
//         } catch (IllegalArgumentException e) {
//             System.out.println(-1);
//         }
        // Check for special cases
        if (n <= 0 || m < 0) {
            return -1;
        }

        // Calculate the Nth root using Math.pow()
        double result = Math.pow(m, 1.0 / n);

        // Round the result to the nearest integer
        int roundedResult = (int) Math.round(result);

        // Check if the rounded result is correct
        if (Math.pow(roundedResult, n) == m) {
            return roundedResult;
        } else {
            return -1;
        }
    }
}
