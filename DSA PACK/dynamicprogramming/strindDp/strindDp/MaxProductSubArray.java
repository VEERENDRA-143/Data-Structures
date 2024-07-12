public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        return f(0, nums,1);
    }
    public static int f(int ind,int[] nums,int pro){
        if (ind == nums.length-1) {
            return pro;
        }
        int take = f(ind+1, nums, pro*nums[ind]);
        if (ind == 0) {
            pro = nums[ind];
        }
        int notTake = f(ind+1, nums, pro);
        

        return Math.max(pro , Math.max(take, notTake));
    }
}
