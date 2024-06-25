public class MinNoOfKConsicutivebits {
    public static void main(String[] args) {
        int[] nums = {0,1,0} ;
        int  k = 1;
        minKBitFlips(nums, k);
    }
    public static void minKBitFlips(int[] nums, int k) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && (i+k) <= nums.length-1) {
                for (int j = i; j < i+k; j++) {
                    nums[i] = nums[i] == 0?1:0;
                }
                c++;
            }
        }
        
        System.out.println(c);
    }
}
