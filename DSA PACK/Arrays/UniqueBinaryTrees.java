public class UniqueBinaryTrees {
    public static int dp[] = new int[20];
    public static void main(String[] args) {
        int n=3;
        
        System.out.println(numTrees(n));
    }
    

    public static int numTrees(int n) {
        if (n <= 1)
            return 1;
        // In case if the value is already present in the
        // array just return it and no need to calculate it
        
        if (dp[n] > 0)
            return dp[n];
        for (int i = 1; i <= n; i++)
            dp[n] += numTrees(i - 1) * numTrees(n - i);
            
        return dp[n];
    }
}
