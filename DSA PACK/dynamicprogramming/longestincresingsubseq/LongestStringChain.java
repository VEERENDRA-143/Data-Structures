// https://leetcode.com/problems/longest-string-chain/description/

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(words));
    }
    public static int longestStrChain(String[] words) {
        // Arrays.sort(words, Comparator.comparing(String::length));
        Arrays.sort(words, Comparator.comparing(String::length));
        int n = words.length;
        int[] dp = new int[words.length+1];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (check(words[i],words[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
    private static boolean check(String string1, String string2) {
        if (string1.length() != string2.length()+1) {
            return false;
        }
        int first = 0;
        int second = 0;
        while (first < string1.length()) {
            if (second < string2.length() && string1.charAt(first) == string2.charAt(second)) {
                first++;
                second++;
            }else{
                first++;
            }
        }
        return first == string1.length() && second == string2.length();
    }
}
