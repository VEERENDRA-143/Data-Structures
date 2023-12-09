import java.util.Arrays;

public class ProductOfArrayAceptSelf {
    public static void main(String[] args) {
        int[] arr = { -1,1,0,-3,3 };
        System.out.println(Arrays.toString(productofarray(arr)));
    }

    static int[] productofarray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            int temp = 1;
            for (int j = 0; j < ans.length; j++) {
                if (i != j) {
                    temp = temp * nums[j];
                }
            }
            ans[i] = temp;
        }
        return ans;
    }
}
