public class MaxNoOfJumpsToreachlastIndex {
    public static void main(String[] args) {
        int[] nums = {1,3,6,4,1,2};
        int target = 2;
        System.out.println(maximumJumps(nums, target));
    }
    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp= new int[n];
        System.out.println("memo = "+ memo(0, target, nums, dp));
        return f(0, target, nums);
    }

    public static int f(int ind,int target,int[] nums){

        if (ind == nums.length-1) {
            return 0;
        }

        if ( ind > nums.length-1) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        for (int j = ind+1; j < nums.length; j++) {
            int diff = nums[j] - nums[ind];
            if ( ind < j &&  -target <= diff && diff <= target) {
                int noofjumps =  1 + f(j, target, nums);
                max = Math.max(max, noofjumps);
            }
        }

        return max;
    }

    public static int memo(int ind,int target,int[] nums,int[] dp){

        if (ind == nums.length-1) {
            return 0;
        }

        if ( ind > nums.length-1) {
            return Integer.MIN_VALUE;
        }

        if (dp[ind] != 0) {
            return dp[ind];
        }

        int max = Integer.MIN_VALUE;
        for (int j = ind+1; j < nums.length; j++) {
            int diff = nums[j] - nums[ind];
            if ( ind < j &&  -target <= diff && diff <= target) {
                int noofjumps =  1 + memo(j, target, nums,dp);
                max = Math.max(max, noofjumps);
            }
        }

        return dp[ind] = max;
    }

}
