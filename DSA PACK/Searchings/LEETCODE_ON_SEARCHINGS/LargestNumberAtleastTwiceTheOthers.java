// You are given an integer array nums where the largest integer is unique.

// Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

public class LargestNumberAtleastTwiceTheOthers {
    public static void main(String[] args) {
        int[] nums=  {1,2,3,4};
        System.out.println(dominantIndex(nums));
    }

    static int dominantIndex(int[] nums) {
        
        int largestele = FindLargestele(nums);

        int largestindex = findlargeInde(nums,largestele);

        if (nums[largestindex] == 2*nums[largestindex -1]) {
            return largestindex;
        }

        return -1;
    }

    private static int findlargeInde(int[] nums, int largestele) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == largestele) {
                return i;
            }
        }
        return 0;
    }

    private static int FindLargestele(int[] nums) {
        int largest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>largest) {
                largest = nums[i];
            }
        }
        return largest;
    }


}
