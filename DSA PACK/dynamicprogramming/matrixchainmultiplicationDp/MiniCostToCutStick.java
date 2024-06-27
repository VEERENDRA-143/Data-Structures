import java.util.Arrays;

public class MiniCostToCutStick {
    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        int n = 7;
        System.out.println(minCost(n, cuts));
    }
    public static int minCost(int n, int[] cuts) {
        int cutsLen = cuts.length;
        int[] arr = new int[cutsLen+2];
        int ind = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( i == 0) {
                arr[i] = 0;

            }
            else if (i == arr.length-1) {
                arr[i] = n;
            }
            else{
                arr[i] = cuts[i-1];
            }
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        int[][] dp = new int[cutsLen+1][cutsLen+1];
        
        System.out.println(memo(1, cutsLen, arr, dp));
        return f(1, cutsLen, arr);
    }
    public static int f(int i,int j,int[] cuts){
        if (i > j) {
            return 0;
        }
        int mini = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int cost = cuts[j+1] - cuts[i-1]  + f(i, k-1, cuts) + f(k +1, j, cuts);
            if (cost < mini) {
                mini = cost;
            }
        }
        return mini;
    }

    public static int memo(int i,int j,int[] cuts,int[][] dp){
        if (i  > j) {
             return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[k+1]- cuts[i-1] + memo(i, k-1, cuts,dp)+memo(k+1, j, cuts,dp);
            if (cost < mini) {
                mini = cost;
            }
        }
        return dp[i][j]= mini;
    }

    
}
