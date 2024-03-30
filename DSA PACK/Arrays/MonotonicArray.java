public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(isMonotonic(nums));
    }
    public  static boolean isMonotonic(int[] nums) {
        if (nums.length==1) {
            return true;
        }
        boolean res= false;
        if (nums[0] <= nums[nums.length-1]) {
            // Strincly Incresing
            int i=0;
            int j=1;
            while (j < nums.length) {
                if (nums[i]<=nums[j]) {
                    i++;
                    j++;
                    res= true;
                }
                else{
                    return  false;
                }
            }
        }
        else{
            // Strictly Decresing
            int i=0;
            int j=1;
            while (j < nums.length) {
                if (nums[i]>=nums[j]) {
                    i++;
                    j++;
                    res= true;
                }
                else{
                    return  false;
                }
            }
        }
        return res;
    }
}
