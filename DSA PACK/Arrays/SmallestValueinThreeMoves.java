import java.util.Arrays;
// Google 


public class SmallestValueinThreeMoves {
    public static void main(String[] args) {
        int[] nums = {6,6,0,1,1,4,6};
        System.out.println(minDifference(nums));
    }

    // Greedy Method

    // Hint :  The minimum difference possible is obtained by removing three elements between
    //         the three smallest and three largest values in the array.

    public static int minDifference(int[] nums) {
        if (nums.length<=4) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        
        // CASE 1: when changing only from beg
        res = Math.min(res, Math.abs(nums[3] - nums[n - 1]));
        
        // CASE 2: when change two from beg and one from last
        res = Math.min(res, Math.abs(nums[2] - nums[n - 2]));
        
        // CASE 3: when change only from beg and two from last
        res = Math.min(res, Math.abs(nums[1] - nums[n - 3]));
        
        // CASE 4: when change all the values from last
        res = Math.min(res, Math.abs(nums[0] - nums[n - 4]));
        
        return res;
    }
}
