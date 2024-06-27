public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
        
    }
    public static int maxCoins(int[] nums){
        int n = nums.length;
        int[] arr= new int[n+2];
        for (int i = 0; i < arr.length; i++) {
            if ( i == 0 || i == arr.length-1) {
                arr[i] = 1;
            }
            else{
                arr[i] = nums[i-1];
            }
        }
        int[][] dp = new int[n+1][n+1];
        System.out.println(memo(1, n, arr, dp));
        return f(1, n, arr);
    }

    public static int f(int i,int j,int[] nums){
        if (i  > j) {
            return 0;
        }
        int maxi  = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
          
            int cost = (nums[i-1]) * nums[k] * (nums[j+1]) + f(i, k-1, nums) +  f(k+1, j, nums);
            maxi  = Math.max(maxi,cost);
        }
        return maxi;

    }

    public static int memo(int i,int j,int[] nums,int[][] dp){ 
        if (i > j) {
            return 0;
        }
        if (dp[i][j]  !=0 ) {
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = nums[i-1] * nums[k] * nums[j+1] + memo(i, k-1, nums, dp)+memo(k+1, j, nums, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }

    
}
 