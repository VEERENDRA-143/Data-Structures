import java.util.Stack;

public class LongestIdealSubSequence {
    public static void main(String[] args) {
        String s = "pvjcci";
        int k = 3;
        System.out.println(longestIdealString(s, k));

    }

    public static int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char cc = s.charAt(i);
            int idx = cc - 'a';
            int max = Integer.MIN_VALUE;

            int left = Math.max((idx - k), 0);
            int right = Math.min((idx + k), 26);

            for (int j = left; j <= right; j++) {
                max = Math.max(max, dp[j]);
            }

            dp[idx] = max + 1;
        }

        int max = Integer.MIN_VALUE;

        for (int ele : dp) {
            max = Math.max(ele, max);
        }

        return max;
    }
}
