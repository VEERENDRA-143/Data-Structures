// https://leetcode.com/problems/palindrome-partitioning-iv/
// Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​
// A string is said to be palindrome if it the same string when reversed.

// Input: s = "abcbdd"
// Output: true
// Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.

import java.util.*;
public class PalindromepartionIV {
    public static void main(String[] args) {
        String s = "abcbdd";
        System.out.println("Recursive Approch TC = O((n^2) * (2^n)) -->> "+check(s));
        System.out.println("DP Approch TC = O((n^2) -->> "+checkPartitioning(s));
    }

    // Recursive method TC = O((n^2) * (2^n))
    public static boolean check(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        checkPartitioning(0, ds, output, s);
        System.out.println(output);

        // finding min length of sub list int output list
        for (List<String>  list : output) {
            if (list.size()==3) {
                String refer = "";
                for (String string : list) {
                    refer += string;
                }
                if (refer.equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    // possibble Combinations of the given string
    public static void checkPartitioning(int index, List<String> subset, List<List<String>> output, String str) {
        if (index == str.length()) {
            output.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (checkPalindrome(str, index, i)) {
                subset.add(str.substring(index, i + 1));
                checkPartitioning(i + 1, subset, output, str);
                subset.remove(subset.size() - 1);
            }
        }
    }

    // Checking the evenry combination is palindrom or not
    public static boolean checkPalindrome(String str, int startIndex, int lastIndex) {
        while (startIndex <= lastIndex) {
            if (str.charAt(startIndex) != str.charAt(lastIndex))
                return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }




    // Dynamic Programming o(n^2) Meoization -->> Botoom Up approch
    public static boolean checkPartitioning(String s) {
        int N = s.length();
        char[] A = s.toCharArray();
        // initialize dp (On^2)
        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0; --i) {
            for (int j = i; j < N; ++j) {
                dp[i][j] = (A[i] == A[j]) && (j - i < 2 || dp[i + 1][j - 1]);
            }
        }
        // find in dp if all three substrings are palindrome, worst case O(N^2)
        for (int i = 1; i < N - 1; ++i) {
            if (dp[0][i - 1]) {
                for (int j = i; j < N - 1; ++j) {
                    if (dp[i][j]) {
                        if (dp[j + 1][N - 1]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
