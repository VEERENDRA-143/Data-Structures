import java.util.*;
public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        return getKPartions(nums,sum/k,nums.length-1,new int[k]);
    }
    private static boolean getKPartions(int[] nums, int target, int n, int[] dp) {
        if (n == -1) {
            return  true;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] + nums[n] <= target) {
                dp[i] += nums[n];
                if (getKPartions(nums, target, n-1, dp)) {
                    return true;
                }
                dp[i] -= nums[n];
            }
            if (dp[i] == 0) {
                break;
            }
        }

        return false;
    }

}
