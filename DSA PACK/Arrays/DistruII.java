import java.util.ArrayList;
import java.util.Arrays;

public class DistruII {
    public static void main(String[] args) {
        int[] nums = {5,14,3,1,2};
        resultArray(nums);

    }
    public static void resultArray(int[] nums) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        int[] n1 = new int[nums.length/2];
        int[] n2 = new int[nums.length/2];

        int[] ans = new int[nums.length];
        int index=0;
        int arrind1 =1;
        int arrind2=1;

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        n1[0] = nums[0];
        n2[0] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int c1 = greaterCount(n1, nums[i]);
            int c2 = greaterCount(n1, nums[i]);

            if (c1 > c2) {
                arr1.add(nums[i]);
                n1[arrind1++] = nums[i];
            }

            else if (c1 < c2 ) {
                arr2.add(nums[i]);
                n2[arrind2++] = nums[i];
            }
            else{
                // Check For Lesser Length Of Array
                if (arr1.size() <= arr2.size()) {
                    arr1.add(nums[i]);
                    n1[arrind1++] = nums[i];
                }
                else{
                    arr2.add(nums[i]);
                    n2[arrind2++] = nums[i];
                }
            }
        }

        for (Integer integer : n1) {
            ans[index++] = integer;
        }
        for (Integer integer : n2) {
            ans[index++] = integer;
        }

        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));

    }

    public static int greaterCount(int[] arr,int val){
        int count=0; 

        for (int i : arr) {
            if (i>val) {
                count++;
            }
        }

        return count;

    }
}
