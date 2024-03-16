public class IncresingTriplets {
    public static void main(String[] args) {
        int[] nums={20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums){
        int max = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length-1; i++) {
            if (nums[i] <= max ) {
                max = nums[i];
            }else if (nums[i] <= min) {
                min = nums[i];
            }
            else{
                return true;
            }

        }
        return false;
    }
}
