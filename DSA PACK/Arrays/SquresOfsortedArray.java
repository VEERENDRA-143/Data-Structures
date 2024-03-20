import java.util.Arrays;

public class SquresOfsortedArray {
    public static void main(String[] args) {
        int[] nums= {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int[] ans  = new int[nums.length];
        for (int i =0;i<nums.length;i++) {
            ans[i] = (int)Math.pow(Math.abs(nums[i]), 2);
        }
        Arrays.sort(ans);
        return ans;
    }
}
