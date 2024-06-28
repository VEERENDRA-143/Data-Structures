public class JumpGameIII {
    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        int start = 2;
        System.out.println(canReach(arr, start));
    }
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] dp = new boolean[n];
        System.out.println("memo = "+memo(start, arr, dp));
        return f(start, arr);
    }

    public static boolean f(int ind,int[] nums){

        if (ind > nums.length-1 || ind < 0 || nums[ind] < 0) {
            return false;
        }

        if (nums[ind] == 0) {
            return true;
        }
        int temp = nums[ind];
        nums[ind] = -1;
        boolean check = f(ind+temp, nums) || f(ind-temp, nums);
        nums[ind]  = temp;

        return check;
    }

    public static boolean memo(int ind , int[] nums,boolean[] dp){

        if (ind > nums.length-1 || ind < 0 || nums[ind] < 0) {
            return false;
        } 
        if (nums[ind]  == 0) {
            return true;
        }

        if (dp[ind]== true) {
            return true;
        }  

        int temp = nums[ind];
        nums[ind] = -1;

        boolean  check = memo(ind+temp, nums, dp) || memo(ind-temp, nums, dp);

        nums[ind] = temp;
        return dp[ind] = check;
    }
}
