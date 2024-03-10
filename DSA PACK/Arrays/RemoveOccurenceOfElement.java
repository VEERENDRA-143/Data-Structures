public class RemoveOccurenceOfElement {
    public static void main(String[] args) {
        
        int[] nums = {0,0,1,1,1,2,2,3,3,4,4,5,6,6};
        System.out.println(removeDuplicates(nums));

    }
    public static int removeElement(int[] nums, int val) {
        int count=0;
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        
        return count;
    }
    public static int removeDuplicates(int[] nums) {
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[count] = nums[i];  
                count++;
            }
        }
        
        return count;
    }
}
