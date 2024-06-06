public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7; 
        System.out.println(findMinPath(m, n));

    }
    public static int findMinPath(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(dp, m, n, 0, 0);
    }

    // TC -> O(n*2^n)
    private static int helper(int[][] dp, int m, int n, int p1, int p2) {
        if (p1 + 1 == m && p2 + 1 == n) {
            return 1;
        }
        if (p1 == m)
            return 0;
        if (p2 == n)
            return 0;
        if (dp[p1][p2] != 0) {
            return dp[p1][p2];
        }
        dp[p1][p2] = helper(dp, m, n, p1 + 1, p2) + helper(dp, m, n, p1, p2 + 1);
        
        return dp[p1][p2];
    }
}
