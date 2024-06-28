import java.util.*;
public class PartionArrayMaxSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k =3;
        // System.out.println(maxSumAfterPartitioning(arr, k));
        System.out.println(tabulation(arr, k));
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] dp =new int[n+1][k+1];
        System.out.println(memo(0, k, arr, dp));
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return f(0, k, arr);
    }
    public static int f(int i,int k,int[] arr){

        if (i == arr.length) {
            return 0;
        }

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(arr.length, i+k); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len*maxi) + f(j+1, k, arr);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

    public static int memo(int i,int k,int[] arr,int[][] dp){
        if (i == arr.length) {
            return 0;
        }

        if (dp[i][k] != 0) {
            return dp[i][k];
        }

        int len = 0;
        int max= Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(arr.length, i+k); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = (len*max) + memo(j+1, k, arr,dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[i][k] = maxAns;
    }

    public static int tabulation(int[] nums,int k){
        int n = nums.length;
        int[][]  dp =new int[n+1][k+1];

        for (int i = n-1; i >= 0; i--) {
            int len = 0;
            int max= Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(n, i+k); j++) {
                len++;
                max = Math.max(max, nums[j]);
                int sum = (len*max) + dp[j+1][k];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i][k] = maxAns;
        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return dp[0][k];
    }
}
