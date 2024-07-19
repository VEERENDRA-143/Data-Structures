// https://leetcode.com/problems/interleaving-string/

import java.util.Arrays;

public class InterLeavingString {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 > n3)
            return false;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        boolean ans = f(s1, s2, s3, 0, 0, 0, dp);
        for (boolean[] bs : dp) {
            System.out.println(Arrays.toString(bs));
        }
        return ans;
    }

    public static boolean f(String s1, String s2, String s3, int s1Ind, int s2Ind, int s3Ind, boolean[][] dp) {

        if (s3Ind == s3.length()) {
            return true;
        }
        if (dp[s1Ind][s2Ind]) {
            return true;
        }
        boolean res = false;
        if (s1Ind < s1.length() && s2Ind < s2.length() && s1.charAt(s1Ind) == s3.charAt(s3Ind)
                && s2.charAt(s2Ind) == s3.charAt(s3Ind)) {
            res = f(s1, s2, s3, s1Ind + 1, s2Ind, s3Ind + 1, dp) || f(s1, s2, s3, s1Ind, s2Ind + 1, s3Ind + 1, dp);
        } else if (s1Ind < s1.length() && s1.charAt(s1Ind) == s3.charAt(s3Ind)) {
            res = f(s1, s2, s3, s1Ind + 1, s2Ind, s3Ind + 1, dp);
        } else if (s2Ind < s2.length() && s2.charAt(s2Ind) == s3.charAt(s3Ind)) {
            res = f(s1, s2, s3, s1Ind, s2Ind + 1, s3Ind + 1, dp);
        }
        return dp[s1Ind][s2Ind] = res;
    }
}
