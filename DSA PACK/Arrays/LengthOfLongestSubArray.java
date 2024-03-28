public class LengthOfLongestSubArray {
    public static void main(String[] args) {
        int[] nums={1,11};
        int k=3;
        maxSubarrayLength(nums, k);
    }
    public static void maxSubarrayLength(int[] nums, int k){
        int start = 0;
        int end = 0;
        int maxEle = FindMaxElement(nums);
        int[] fre = new int[maxEle+1];

        for (int i = 0; i < nums.length; i++) {
            fre[nums[i]]++;
            if (fre[nums[i]]>k) {
                start++;
            }
            end++;
        }

        System.out.println(end-start);

    }
    private static int FindMaxElement(int[] nums) {
        int maxEle = 0;
        
        for (int i : nums) {
            if (i>maxEle) {
                maxEle = i;
            }
        }

        return maxEle;
    }

}
