import java.util.ArrayList;
import java.util.List;

public class MinimumOperationsToCollect {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        // nums.add(2);
        nums.add(1);
        nums.add(5);
        nums.add(4);
        nums.add(2);
        int k = 2;
        minOperations(nums, k);
    }
    public static void minOperations(List<Integer> nums, int k) {
        
        int minIndex = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            minIndex = Math.min(minIndex, nums.lastIndexOf(i));
            if (minIndex == 0) {
                System.out.println(nums.size());
                return;
            }
            // System.out.println(nums.lastIndexOf(i));
        }
        System.out.println(nums.size()-minIndex);
    }
}
