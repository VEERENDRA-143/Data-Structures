public class MiniNoOfFlipsToMakeBinaryArraytoAllOnesII {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1};
        minOperations(nums);

    }
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        boolean flipped = false;
        
        for (int i = 0; i < n; i++) {
            if ((nums[i] == 0 && !flipped) || (nums[i] == 1 && flipped)) {
                // If we encounter a 0 in the unflipped state or a 1 in the flipped state, flip from here
                operations++;
                flipped = !flipped;
            }
        }
        
        return operations;
    }
}
