// https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos


import java.util.*;
public class Arraypartitionwithminimumdifference {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;
        minSubsetSumDifference(arr, n);

    }
    public static void minSubsetSumDifference(int []arr, int n) {
        System.out.println(minSubsetsum(arr, n));
    }
    public static int minSubsetsum(int[] nums,int n){
        int totalSum   = Arrays.stream(nums).sum();
        int k = totalSum;
        boolean[][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
            if (nums[i] <= k) {
                dp[i][nums[0]] = true;
            
            }
            for (int ind = 1; ind < dp.length; ind++) {
                for (int target = 1; target <= k; target++) {
                    boolean notTake  = dp[ind-1][target];
                    boolean take = false;
                    if (nums[ind] < target) {
                        take = dp[ind-1][target-nums[ind]];
                    }
                    dp[ind][target] = take || notTake;
                }
            }
        }
        int mini = (int)1e9;
        for (int s1 = 0; s1 < totalSum/2; s1++) {
            if (dp[n-1][s1] == true) {
                int s2 = totalSum-s1;
                mini = Math.min(mini, Math.abs(s1-s2));
            }
        }
        return mini;
    }

}
