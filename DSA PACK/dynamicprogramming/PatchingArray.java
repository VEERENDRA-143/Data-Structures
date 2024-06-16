public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1,4,10,3,1};
        int n = 20;
        System.out.println(minPatches(nums, n));
    }
    
    public static int minPatches(int[] nums, int n) {
        long patch = 0;
        int count = 0;
        int index = 0;
        while (patch < n) {
            if (index < nums.length && patch + 1 >= nums[index]) {
                patch += nums[index];
                index++;
            } else {
                patch += (patch + 1);
                count++;
            }
        }

        return count;
    }


}
