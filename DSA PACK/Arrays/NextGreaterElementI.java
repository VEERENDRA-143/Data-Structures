public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1={2,4};
        int[] nums2={1,2,3,4};
        nextGreaterElement(nums1, nums2);
    }
    public static void  nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i=0;i<nums1.length;i++) {
            int ind = findOccurence(nums1[i],nums2);
            int nextGreater = findGreater(ind,nums2,nums1[i]);
            ans[i] = nextGreater;
            System.out.print(nextGreater+" ");
        }
    }
    private static int findGreater(int ind, int[] nums2,int ele) {
        
        for (int i = ind; i < nums2.length; i++) {
            if(nums2[i] > ele ){
                return nums2[i];
            }
        }
        return -1;
    }
    private static int findOccurence(int ele, int[] nums2) {
        int ind = 0;
        for (int i : nums2) {
            if (ele != i) {
                ind++;
            }
            else{
                return ind+1;
            }
        }
        return ind;
    }
}
