// https://leetcode.com/problems/palindrome-partitioning/description/?envType=daily-question&envId=2024-05-22
// Given a string s, partition s such that every substring of the partition is a 
// palindrome.
// Return all possible palindrome partitioning of s.

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

import java.util.*;

public class PalindromePartionaing {

    public static void main(String[] args) {
        String s = "abcbdd";
        partition(s);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        palindromePartition(0, ds, output, s);
        System.out.println(output);
        System.out.println(minCut(s));
        return output;
    }

    public static void palindromePartition(int index, List<String> subset, List<List<String>> output, String str) {
        if (index == str.length()) {
            output.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (checkPalindrome(str, index, i)) {
                subset.add(str.substring(index, i + 1));
                palindromePartition(i + 1, subset, output, str);
                subset.remove(subset.size() - 1);
            }
        }
    }

    public static boolean checkPalindrome(String str, int startIndex, int lastIndex) {
        while (startIndex <= lastIndex) {
            if (str.charAt(startIndex) != str.charAt(lastIndex))
                return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }


    // https://leetcode.com/problems/palindrome-partitioning-ii/description/

// Given a string s, partition s such that every  substring of the partition is a palindrome
// Return the minimum cuts needed for a palindrome partitioning of s.

// Input: s = "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

    // DP Approch Memoiztion O(n^2)
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; j++, i++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int[] minCut = new int[n];
        minCut[0] = 0;

        for (int i = 1; i < n; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (dp[j][i]) {
                    ans = Math.min(ans, j - 1 < 0 ? 0 : minCut[j - 1] + 1);
                }
            }
            minCut[i] = ans;
        }

        return minCut[n - 1];
    }


    // 
    
    

}
