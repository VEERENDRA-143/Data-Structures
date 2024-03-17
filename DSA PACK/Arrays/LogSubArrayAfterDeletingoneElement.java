
// Given a binary array nums, you should delete one element from it.

// Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

public class LogSubArrayAfterDeletingoneElement {

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        int leftLen = 0, rightLen = 0, pos = 0, max = 0;
        
        while (pos < nums.length) {
            //Left subarray increases
            if (nums[pos] == 1) {
                ++pos;
                ++leftLen;
            }
            else if (nums[pos] == 0) {
                rightLen = 0;
                ++pos;
                
                //Find out size of right subarray.
                while (pos < nums.length && nums[pos] == 1) {
                    ++pos;
                    ++rightLen;
                }
                max = Math.max(max, leftLen + rightLen);
                leftLen = rightLen;
            }
        }
        if (leftLen == nums.length)
            max = nums.length-1;
        
        return max;
    }
}


// Example 1:

// Input: nums = [1,1,0,1]
// Output: 3
// Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.


// Example 2:

// Input: nums = [0,1,1,1,0,1,1,0,1]
// Output: 5
// Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].


// Example 3:

// Input: nums = [1,1,1]
// Output: 2
// Explanation: You must delete one element.