public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println("tabulation = "+ tabulation(nums));
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        System.out.println("memeo = "+memo(0, nums, dp));
        return f(0, nums);
    }
    public static int f(int ind,int[] nums){

        if (ind >= nums.length-1) {
            return 0;
        }

        int mini = 9999;

        for (int j = ind+1; j <= Math.min(nums.length-1, ind+nums[ind]); j++) {
            int noOfJumps = 1 + f(j, nums);
            mini = Math.min(mini, noOfJumps);
        }

        return mini;

    }

    public static int memo(int ind,int[] nums,int[] dp){
        if ( ind == nums.length-1) {
            return 0;
        }
        if(dp[ind] != 0) return dp[ind];
        int mini= 99999;
        for (int j = ind+1; j <= Math.min(nums.length-1, ind+nums[ind]); j++) {
            int noOfJumps =   1 + memo(j, nums,dp);
            mini  = Math.min(mini, noOfJumps);
        }

        return dp[ind] = mini;
    }

    public static int tabulation(int[] nums){
        int n = nums.length;
        int[]  dp = new int[n];

        for (int ind = n-2; ind >= 0; ind--) {
            int mini= 99999;
            for (int j = ind+1; j <= Math.min(nums.length-1, ind+nums[ind]); j++) {
                int noOfJumps =   1 + dp[j];
                mini  = Math.min(mini, noOfJumps);
            }
            dp[ind] = mini;
        }
        return dp[0];
    }

}
