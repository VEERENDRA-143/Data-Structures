public class MultiplayingWithTwo {
    public static void main(String[] args) {
        int[] nums={2,7,9};
        System.out.println(findFinalValue(nums, 3));
    }

    static int findFinalValue(int[] nums, int original) {
        int found = FindOriginalIndex(nums,original);

        if (found == -1 ) {
            return original;
        }
        
        return findFinalValue(nums, 2*nums[found]);

    }

    private static int FindOriginalIndex(int[] nums, int original) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==original) {
                return i;
            }
        }
        return -1;
    }

}
