import java.util.Arrays;
import java.util.Stack;

public class MaximumSubArraysMinProduct {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5 };
        System.out.println(maxSumMinProduct(num));
    }

    public static int maxSumMinProduct(int[] nums) {

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (nums[j] < min) {
                    min = nums[j];
                }
                max = Math.max(max, sum * min);
            }

        }
        return (int) (max% 1000000007);
    }

    public static int maxSumMinProduct2(int[] n) {
        Stack<Integer> st = new Stack<>();
        long dp[] = new long[n.length + 1], res = 0;
        for (int i = 0; i < n.length; ++i)
            dp[i + 1] = dp[i] + n[i];
        for (int i = 0; i <= n.length; ++i) {
            while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
                int j = st.pop();
                res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
            }
            st.push(i);
        }
        return (int) (res % 1000000007);
    }
}
