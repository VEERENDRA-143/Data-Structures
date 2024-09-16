// Bob has a string S and Alice has a string T. Each day. Bob takes his string S and appends it to the final string K. For example, if S is "ab" then K will also be "ab". (on the first day) then on the second day. K becomes "abab". On the third day. K becomes "ababab" and so on.

// Your task is to help Alice find and return an integer value, representing the day when the string K contains T as a sequence for the first time.

// Note:

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Do not alter the onder of the string while choosing a subsequence
// Input Specification:

// input1: A string value S. representing the string Bob has.

// input2: A string value T. representing the string Alice has.

// Output Specification:

// Return an integer value, representing the day when string K contains T as a subsequence for the first time.

// Example 1:

// input1: mtle

// input2: mettl
// Output: 3

// Explanation:

// Given the initial string "mtle", we can find the day when the string "mettl" appears as a subsequence in the following way:

// 1. On the first day, the string K is "mtle", and does not contain the subsequence "mett!".

// 2. On the second day, the string K becomes "mtlemtle". However, the string still does not contain the subsequence "metti".

// 3. On the third day, the string K becomes "mtlemtle" + "mtle" = "mtlemtlemtle". Now the string K contains the subsequence "mett!" for the first time.

// Therefore, a minimum of 3 days is required for string K to contain the subsequence "mettl". Hence. 3 is returned as the output.

public class FirstDayOdSubsequence {

    public static void main(String[] args) {
        String S = "abcxyz";
        String T = "xyz";
        findSubsequence(S, T);
    }

    public static void findSubsequence(String S, String T) {

        String K = S;
        int in = 0;
        int ans = 1;

        int i = 0;
        while (i < T.length()){
            char ch = T.charAt(i);
            int check = findCharInK(K, ch, in);
            if (check < 0) {
                K+=S;
                ans++;
            }
            else{
                in = check+1;
                i++;
            }
        }
        System.out.println(ans);

    }

    private static int findCharInK(String K, char ch, int ind) {

        for (int i = ind; i < K.length(); i++) {
            if (K.charAt(i) == ch){
                return i;
            }
        }

        return -1;
    }

}