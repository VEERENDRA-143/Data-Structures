public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
    public static void maxSubArray(int[] nums) {
        if (nums.length==1) {
            System.out.println(nums[0]);
            return ;
        }
        int max=Integer.MIN_VALUE;
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            for (int j = i+1; j < nums.length; j++) {
                max = Math.max(max, sum);
                sum = sum+nums[j];
                
            }
            max = Math.max(max, sum);
            sum=0;
        }
        System.out.println(max);
    }
}
