import java.util.Arrays;

public class MeargeArrays {
    public static void main(String[] args) {
        int[][] nums1 ={{1,2},{6,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] ans = ArrayMearging(nums1, nums2);
        for (int[] i : ans) {
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static int[][] ArrayMearging(int[][] nums1, int[][] nums2){
        int[] arr = new int[50];
        int count = 0;
        for (int[] ints : nums1)
            arr[ints[0]] += ints[1];
        for (int[] ints : nums2)
            arr[ints[0]] += ints[1];
        for (int i : arr)
            if (i > 0)
                count++;
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            result[index][0] = i;
            result[index][1] = arr[i];
            index++;
        }
        return result;
    }
}

// while (i<nums1.length && j<nums2.length) {
//             anslen++;
//             if (nums1[i][0]==nums2[i][0]) {
//                 ans[anslen][0] = nums1[i][0];
//                 ans[anslen][1] = nums1[i][1]+nums2[i][1];
//             }
//             else if (nums1[i][0]<nums2[i][0]) {
//                 ans[anslen][0] = nums1[i][0];
//                 ans[anslen][1] = nums1[i][1];
//             }
//             else if (nums2[i][0]<nums1[i][0]) {
//                 ans[anslen][0] = nums2[i][0];
//                 ans[anslen][1] = nums2[i][1];
//             }
//             else{
//                 ans[anslen][0] = anslen;
//                 ans[anslen][1] = 0;
//             }
//             i++;
//             j++;

//         }
