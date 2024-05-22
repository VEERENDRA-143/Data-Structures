import java.util.Arrays;

public class HouseRoberryII {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        rob(nums);
    }
    public static void rob(int[] nums) {
        int[] first = new int[nums.length-1];
        int[] second = new int[nums.length-1];
        for (int i = 0; i < first.length; i++) {
            first[i] = nums[i];
            second[i] = nums[i+1];
        }
        // int ans1 = recurSive(first, 0);
        // int ans2 = recurSive(second, 0);
        int ans1 = robDP(first);
        int ans2 = robDP(second);
        System.out.println(Math.max(ans1, ans2));
    }
    public static int recurSive(int[] nums,int index){
        if (index >= nums.length) {
            return 0;
        }
        if (index < 0 ) {
            return nums[index];
        }
        int t = nums[index] + recurSive(nums, index+2);
        int nt = recurSive(nums, index+1);
        return Math.max(t, nt);
    }
    // Tabulation
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
