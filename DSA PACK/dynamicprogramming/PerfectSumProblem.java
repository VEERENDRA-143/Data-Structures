import java.util.*;
public class PerfectSumProblem {
    public static void main(String[] args) {
        int[] nums ={5, 2, 3, 10, 6, 8};
        int n = nums.length;
        int target = 10;
        System.out.println(perfectSum(nums, n, target));
    }
    public static int perfectSum(int[] nums,int n, int k) {
        int[][]  dp = new int[n][k+1];
        for (int[] is : dp) {
            Arrays.fill(is,-1);
        }
        System.out.println(memoizationApproch(n-1, k, nums, dp));
        return countSubsetsEqualtoSum(n-1,k,nums);
    }
    private static int countSubsetsEqualtoSum(int ind, int target, int[] nums) {
        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
            if (nums[ind] == target) {
                return 1;
            }
            return 0;
        }
        int notPick = countSubsetsEqualtoSum(ind-1, target, nums);
        int pick = 0;
        if (nums[ind] <= target) {
            pick = countSubsetsEqualtoSum(ind-1, target-nums[ind],nums);
        }
        return  notPick+pick;
    }

    private static int memoizationApproch(int index,int target,int[] nums,int[][]  dp){
        if(target == 0) return 1;
        if (index == 0) {
            if (nums[index] ==  target) {
                return  1;
            }
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notPick = memoizationApproch(index-1, target, nums,dp);
        int pick = 0;
        if (nums[index] <= target) {
            pick = memoizationApproch(index-1, target - nums[index], nums,dp);
        }
        return  dp[index][target] = notPick+pick;
    }
}
