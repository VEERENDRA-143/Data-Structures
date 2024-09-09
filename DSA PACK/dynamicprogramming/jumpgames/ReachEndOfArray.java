public class ReachEndOfArray {
    static int ans = 0;
    public static void main(String[] args) {
        int[] nums = {1,3,1,5};
        findMaxScore(nums);
    }
    public static void findMaxScore(int[] nums){
        int n = nums.length;
        f(0,n-1,nums);
        System.out.println(ans);
    }
    private static int f(int ind, int n, int[] nums) {
        
        if (ind == n) {
            return 0; 
        }

        for (int i = ind+1; i <= n; i++) {
            if (nums[ind] < nums[i]) {
                f(i, n, nums);
                ans += ((i-ind)*nums[ind]);
            }
        }
        return ans;
    }
}
