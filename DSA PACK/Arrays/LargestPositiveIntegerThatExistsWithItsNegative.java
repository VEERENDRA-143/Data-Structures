import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] nums={-1,2,-7,3};
        System.out.println(findMaxK(nums));
    }
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0 && nums[i] > 0 ; i--) {
            boolean check = findmax(nums,nums[i]);
            if (check) {
                System.out.println(nums[i]);
                return nums[i];
            }
        }
        return -1;
    }
    private static boolean findmax(int[] nums, int i) {
        int index = 0;
        while (nums[index] < 0 ) {
            if (i == Math.abs(nums[index])) {
                return true;
            }
            index++;
        }
        return false;
    }
}
