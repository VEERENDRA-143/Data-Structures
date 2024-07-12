public class CountSortedVowelStrings {
    public static void main(String[] args) {
        CountSortedVowelStrings o= new CountSortedVowelStrings();
        System.out.println(o.countVowelStrings(2));
    }
    public int countVowelStrings(int n) {
        String s = "aeiou";
        int[][] dp =new int[n+1][s.length()+1];
        return f(0, s.length(), n,dp);
    }
    public int f(int ind,int len,int n,int[][] dp){
        if (n == 0) { 
            return 1;
        }
        if (dp[n][ind] != 0) {
            return dp[n][ind];
        }
        int res = 0;
        for (int i = ind; i < len; i++) {
            res += f(i, len, n-1,dp);
        }
        return dp[n][ind] = res;
    }
}
