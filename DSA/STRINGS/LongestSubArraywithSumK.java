import java.util.Arrays;

public class LongestSubArraywithSumK {
    public static void main(String[] args) {
        int[] A = { -1, 2, 3 };
        // int[] B = { 2,3,4,4,5,6 };
        int k = 5;
        // System.out.println("main(4)");
        f(A, k);
    }

    public static void f(int[] A, int k) {
        System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(B));

        int n = A.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int sum = 0;
        while (right < n) {
            
            if (sum < k) {
                sum += A[right];
                right++;
            }
            else if (sum > k) {
                sum -= A[left];
                left++;
            }

            if (sum == k){
                max = Math.max(max, right - left + 1);
                left++; 
                right++;
            }

        }
        System.out.println(max);
    }
}
