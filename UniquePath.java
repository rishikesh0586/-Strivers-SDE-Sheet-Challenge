public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findPath(0, 0, m, n, dp);
    }
    int findPath(int path1, int path2, int m, int n, int[][] dp) {
        if (path1+1==m && path2+1==n) return 1;
        if (path1==m) return 0;
        if (path2==n) return 0;
        if (dp[path1][path2]!=0) return dp[path1][path2];
        dp[path1][path2] = findPath(path1+1, path2, m, n, dp) + findPath(path1, path2+1, m ,n, dp);
        return dp[path1][path2];
    }
}
