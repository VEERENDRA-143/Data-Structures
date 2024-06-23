import java.util.Arrays;

public class MaxmizeTotalCost {
    public static void main(String[] args) {
        int[] nums = { 1, -2, 3, 4 };
        System.out.println(maximumTotalCost(nums));
    }

    public static long maximumTotalCost(int[] nums) {
        if(nums.length == 1) {
            return (long) nums[0];
        }
        long[] dp = new long[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0]+nums[1], nums[0]-nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], dp[i-2]+nums[i-1]-nums[i]);
        }
        return dp[nums.length-1];
    }
    
}
