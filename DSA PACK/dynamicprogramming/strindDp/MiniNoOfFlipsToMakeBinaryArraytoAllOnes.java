public class MiniNoOfFlipsToMakeBinaryArraytoAllOnes {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1};
        minOperations(nums);

    }
    public static int minOperations(int[] nums) {
        int c = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && i+3 <= n) {
                // Flip triplets
                for(int j = i;j <i+3;j++){
                    nums[j] = nums[j] == 0?1:0;
                }
                c++;
            }
        }
        boolean check = checkAllOnes(nums);
        // System.out.println(check ? c:-1);
        return check ? c:-1;
    }
     private static  boolean checkAllOnes(int[] nums) {
        for (int i : nums) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
