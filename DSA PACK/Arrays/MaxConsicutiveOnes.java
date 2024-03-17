import java.util.Arrays;

public class MaxConsicutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int start = 0, zc = 0;
        int ans = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zc++;
            }
            while (zc > k) {
                if (nums[start] == 0) {
                    zc--;
                }
                start++;
            }
            ans = Math.max(end - start + 1, ans);
        }
        return ans;
    }
}
