import java.util.Arrays;

public class LongestIncSubSeq {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        // System.out.println(lengthOfLIS(nums));
        System.out.println(lis(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp =new int[n][n+1];
        return lis(0, -1, nums,dp);
    }

    public static int lis(int ind,int prev_ind,int[] nums,int[][] dp){

        if (ind >= nums.length) {
            return 0;
        }
        if (dp[ind][prev_ind+1] != 0) {
            return dp[ind][prev_ind+1];
        }
        // Not Take
        int len = 0 + lis(ind+1, prev_ind, nums,dp);

        // Take
        if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
          len = Math.max(len,  1 + lis(ind+1, ind, nums,dp));
        }
        return dp[ind][prev_ind+1] = len;
    }

    public static int tabulation(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for (int ind = n-1; ind >= 0; ind--) {
            for (int prev_ind = ind-1; prev_ind >= -1; prev_ind--) {
                
                int len = 0 + dp[ind+1][prev_ind+1];

                if (prev_ind == -1 || nums[ind] % nums[prev_ind]==0) {
                    len = Math.max(len,  1 + dp[ind+1][ind+1]);
                }
                dp[ind][prev_ind+1] = len;
            }

        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return dp[0][0];
    }

    public static int lis(int[] nums ){

        int[] dp =new int[nums.length+1];
        Arrays.fill(dp,1);

        int max = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i],1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return dp[n-1];
    }
}