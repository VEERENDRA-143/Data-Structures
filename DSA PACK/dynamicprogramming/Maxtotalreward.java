import java.util.Arrays;

public class Maxtotalreward {
    public static void main(String[] args) {
        int[] rewardValues={5000,5000};
        axTotalReward(rewardValues);
    }
    public static void axTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        // int sum = 0;
        int[][] dp = new int[rewardValues.length][5000*2+1];

        System.out.println(rec(0, 0, rewardValues));
        System.out.println(memoization(0, 0, rewardValues, dp));
    }

    // Recursion
    public static int rec(int ind,int x,int[] arr){
        if (ind >= arr.length) {
            return x;
        }
        
        int notPick = rec(ind+1, x, arr);
        int pick = -10000001;
        if (x < arr[ind]) {
            pick = rec(ind+1, x+arr[ind], arr);
        }
        return  Math.max(notPick, pick);

    }
    // Memoization
    public static int memoization(int index,int x,int[] arr,int[][] dp){
        if (index >= arr.length) {
            return x;
        }
        if (dp[index][x] != 0) {

            return dp[index][x];
        }
        int notPick = memoization(index+1, x, arr,dp);
        int pick = 0;
        if (arr[index] > x) {
            pick = memoization(index+1, x+arr[index], arr,dp);
        }
        return dp[index][x] = Math.max(notPick, pick);
    }    
}
