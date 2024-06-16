
public class FindSubSetsWithSumK {
    public static void main(String[] args) {
        int[] nums= {1, 4, 4, 5};
        int tar = 5;

        findWays(nums, tar);
    }

    public static void findWays(int[] nums, int tar) {
        
        int[][]  dp= new int[nums.length][tar+1];

        System.out.println(f(nums.length-1, tar, nums,dp));
        
    }

    public static int f(int index,int sum,int[] nums,int[][] dp){
        if (sum == 0) {
            return 1;
        }
        if (index == 0) {
            return  nums[index] == sum ? 1 : 0;
        }
        if (dp[index][sum] != 0) {
            return dp[index][sum];
        }
        int notTake = f(index-1, sum, nums,dp);
        int take= 0;
        if (nums[index] <= sum) {
            take = f(index-1, sum-nums[index], nums,dp);
        }
        return dp[index][sum] = notTake+take;
    }
    
}
