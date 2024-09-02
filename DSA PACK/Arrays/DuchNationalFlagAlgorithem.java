// https://leetcode.com/problems/sort-colors/description/

import java.util.Arrays;

public class DuchNationalFlagAlgorithem {
    public static void main(String[] args) {
        int[] nums = {2};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            if (nums[mid] == 0) {
                // Swap 
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                low++;
                mid++;

            }else if (nums[mid] == 1) {
                mid++;
            }else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
