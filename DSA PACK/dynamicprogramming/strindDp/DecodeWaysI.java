public class DecodeWaysI {
    public static void main(String[] args) {
        String s = "09";
        // System.out.println(numDecodings(s));
        System.out.println(tabulation(s));;
    }
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        return f(0, s,dp);
    }

    public static int f(int ind,String s,int[] dp){

        if (ind == s.length()) {
            return 1;
        }

        if(dp[ind] != 0){
            return dp[ind];
        }

        if (s.charAt(ind ) == '0') {
            return 0;
        }

        int ways = f(ind+1, s,dp);

        if (ind + 1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26) {
            ways+=f(ind+2, s,dp);
        }
        
        return dp[ind] = ways;
    }

    public static int tabulation(String s){

        int n = s.length();
        int[] dp =new int[n+1];
        dp[n] = 1;
        for (int ind = n-1; ind >= 0; ind--) {
            if (s.charAt(ind ) == '0') {
                dp[ind] = 0;
            }else{
            int ways = dp[ind+1];

            if (ind + 1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26) {
                ways += dp[ind+2];
            }
            dp[ind] = ways;
            }
        }
        return dp[0];
    }
}
