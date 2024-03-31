import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionsOfArrays {
    public static void main(String[] args) {
        int[][] nums= {
            {1,2,3},
            {4,5,6}
        };
        int[] nu1 = {1,2,2,1};
        int[] nu2 = {2,2};
        intersect(nu1,nu2);
        
    }
    public static void intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        int max = FindMax(nums);
        int[] fre = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                fre[nums[i][j]]++;
            }
        }
        for (int i =fre.length-1;i>=0;i--) {
            if (fre[i] == nums.length) {
                ans.add(i);
                System.out.println(i);
            }
        }
        System.out.println(Arrays.toString(fre));
    
    }
    private static int FindMax(int[][] nums) {
       int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j]>max) {
                    max = nums[i][j];
                }
            }
        }
       return max;
    }

    public static void intersect(int[] nums1, int[] nums2){
        int[] ans = new int[1001];

        if (nums1.length<=0 || nums2.length<=0) {
            return;
        }
        int start1=0;
        int start2=0;
        while (start1 != nums1.length || start2 != nums2.length) {
            if (nums1[start1] != nums2[start2]) {
                start1++;
            }
            else if (nums1[start1]==nums2[start2]) {
                ans[nums1[start1]]++;
                start1++;
                start2++;
            }
            else{
                start2++;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
