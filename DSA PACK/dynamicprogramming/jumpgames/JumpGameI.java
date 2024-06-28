
public class JumpGameI {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println("tabulation = "+ tabulation(nums));
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];
        System.out.println("memo = "+memo(0, nums, dp));
        return f(0, nums);
    }

    public static boolean f(int ind,int[] nums){

        if ( ind >= nums.length-1) {
            return true;
        }
        if (nums[ind] == 0 && ind < nums.length) {
            return false;
        }
        for (int j = ind+1; j <= Math.min(nums.length-1, ind+ nums[ind]); j++) {
            boolean check = f(j, nums);
            if (check) {
                return true;
            }
        }

        return false;

    }

    public static boolean memo(int ind,int[] nums,boolean[] dp){

        if ( ind >= nums.length-1) {
            return true;
        }
        if ( nums[ind] == 0 && ind < nums.length) {
            return false;
        }

        if (dp[ind] == true) {
            return true;
        }

        for (int j = ind+1; j <= Math.min(nums.length-1,ind+nums[ind]); j++) {
            boolean check = memo(j, nums,dp);
            if (check) {
                return dp[ind] = true;
            }
        }

        
        return dp[ind] = false;

    }

    public static boolean tabulation(int[] nums){
        int n = nums.length;
        boolean[] dp= new boolean[n];
        dp[n-1] = true;

        for (int ind = n-1; ind >= 0; ind--) {

            for (int j = ind+1; j <= Math.min(nums.length-1,ind+nums[ind]); j++) {
                boolean check = dp[j];
                if (check) {
                    dp[ind] = true;
                }
            }
        }

        return dp[0];
    }
}