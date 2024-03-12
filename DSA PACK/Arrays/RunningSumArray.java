import java.util.Arrays;

public class RunningSumArray {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
    public static int[] runningSum(int[] nums) {
        // int[] ans = new int[nums.length];

        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum= sum+nums[i];
            nums[i]=sum;
        }

        return nums;
    }
}
