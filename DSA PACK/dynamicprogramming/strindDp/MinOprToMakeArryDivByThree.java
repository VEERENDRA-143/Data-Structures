import java.util.*;
public class MinOprToMakeArryDivByThree {
    public static void main(String[] args) {
        int[] nums = {3,6,9};
        System.out.println(minimumOperations(nums));
    }
    public static int minimumOperations(int[] nums) {
        int c= 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%3 != 0) {
                c++;
            }
        }
        System.out.println(c);
        return c;
    }
}
