public class KnapSackproblem {
    public static void main(String[] args) {
        int[] weight = {1, 2, 4, 5};
        int[] value = {5, 4, 8, 6};
        int n = weight.length;
        int maxWeight = 5;
        System.out.println(knapsack(weight, value, n, maxWeight));

    }

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp =new int[n][maxWeight+1];
        System.out.println(memoize(n-1, maxWeight, weight, value, dp));
        System.out.println(tabulation(weight, value, n, maxWeight));
        return f(n-1,maxWeight,weight,value);
    }

    private static int f(int ind, int maxWeight, int[] weight, int[] value) {
        if (ind == 0) {
            if (weight[ind] <= maxWeight) {
                return value[0];
            }
            return 0;
        }
        int notPick = 0 + f(ind-1, maxWeight, weight, value);
        int pick = Integer.MIN_VALUE;
        if (weight[ind] <= maxWeight) {
            pick = value[ind] + f(ind-1, maxWeight-weight[ind], weight, value);
        }
        return Math.max(notPick, pick);
    }

    public static int memoize(int ind,int maxWeight,int[] weight,int[] value,int[][] dp){
        if (ind == 0) {
            return weight[ind] <= maxWeight ? value[0] : 0;
        }

        if (dp[ind][maxWeight] != 0) {
            return dp[ind][maxWeight];
        }

        int notTake = 0 + memoize(ind-1, maxWeight, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= maxWeight) {
            take = value[ind] + memoize(ind-1, maxWeight- weight[ind], weight, value, dp);
        }
        return dp[ind][maxWeight] = Math.max(notTake, take);
    }

    public static int tabulation(int[] weight, int[] value, int n, int maxWeight){
        int[][] dp =new int[n][maxWeight+1];
        for (int w = weight[0]; w <= maxWeight; w++) {
            dp[0][w] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                int notTake = 0 + dp[i-1][w];
                int take = Integer.MIN_VALUE;
                if (weight[i] <= maxWeight) {
                    take = value[i] + dp[i-1][maxWeight- weight[i]];
                }
                dp[i][w] = Math.max(notTake, take);
            }
        }
        return dp[n-1][maxWeight];
    }
}
