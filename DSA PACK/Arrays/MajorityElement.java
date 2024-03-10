public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        
        int maxEle = FindMax(nums);
        int[] fre = new int[maxEle+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < fre.length; j++) {
                if (j == nums[i]) {
                    fre[j]++;
                }
            }
            
        }
        int ans = FindMax(fre);

        for (int i = 0; i < fre.length; i++) {
            if (fre[i] == ans) {
                return i;
            }
        }
        return -1;
    }


    private static int FindMax(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i]>max) {
                max = nums[i];
            }

        }
        
        return max;
    }
}