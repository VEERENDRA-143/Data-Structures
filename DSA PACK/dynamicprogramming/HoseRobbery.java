public class HoseRobbery {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        // System.out.println(robDP(nums));
        recurSive(nums);
    }


    // Recursive Method TC = O(2^n), SC = O(n)+Stack space
    public static void recurSive(int nums[]){
        System.out.println(recurSive(nums,0));
    }

    
    private static int recurSive(int nums[], int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (index  < 0) {
            return nums[index];
        }
        int fs = nums[index]+recurSive(nums, index+2);
        int cu = recurSive(nums, index+1);
        return Math.max(fs, cu);
    }

    // Memoization TC = O(n), SC = O(n)
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }


    // Tabulation Space Optimization TC = O(n), SC = O(1)
    public static int robDP(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curri = Math.max(prev,nums[i]+prev2);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    
}

