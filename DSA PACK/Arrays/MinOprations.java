public class MinOprations {
    public static void main(String[] args) {
        int[] nums = {1,5,2,4,1};
        minOperations(nums);
    }

    public static void minOperations(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                int diff = Math.abs(nums[i]-nums[i-1]);
                count += diff+1;
                nums[i] = nums[i-1]+1;
            }
        }
        System.out.println(count);
    }

}
