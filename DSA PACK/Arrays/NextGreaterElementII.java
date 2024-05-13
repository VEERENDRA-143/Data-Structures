public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        nextGreaterElements(nums);
    }
    public static void nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ind = findGreter(i,nums[i],nums);
            ans[i] = ind;
            System.out.print(ind+" ");
        }
    }
    private static int findGreter(int index,int ele, int[] nums) {
        int flag  =0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > ele) { 
                return nums[i];
            }
        }
        for (int i = 0; i < index; i++) {
            if (nums[i] > ele) { 
                return nums[i];
            }
        }
        return -1;
    }
}
