public class CountNoOfTexts {
    public static void main(String[] args) {
        CountNoOfTexts o = new CountNoOfTexts();
        String preString = "22233";
        System.out.println(o.countTexts(preString));
        System.out.println(o.tabulation(preString));
    }   
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[] keys = {0,0,3,3,3,3,3,4,3,4};
        int[] dp= new int[n+1];
        return f(0, pressedKeys, keys,dp);
    }
    public int f(int ind,String s,int[] keys,int[] dp){

        if (ind == s.length()) {
            return 1;
        }
        if (dp[ind] != 0) {
            return dp[ind];
        }

        int key = s.charAt(ind)-'0';
        int repitations = keys[key];
        int count = 0;
        for (int i = 0; i< repitations && ind+ i < s.length() && s.charAt(ind)  == s.charAt(ind+i); i++) {
            count += f(ind+1+i, s, keys,dp);
            count %= (int)1e9;
        }

        return dp[ind] = count;

    }

    public int tabulation(String s){

        int n= s.length();
        int[] dp= new int[n+1];
        int[] keys = {0,0,3,3,3,3,3,4,3,4};
        dp[n] = 1;

        for (int ind = n-1; ind >= 0 ; ind--) {
            int key = s.charAt(ind)-'0';
            int repitations = keys[key];
            int count = 0;
            for (int i = 0; i< repitations && ind+ i < s.length() && s.charAt(ind)  == s.charAt(ind+i); i++) {
                count += dp[ind+1+i];
                count %= (int)1e9;
            }

            dp[ind] = count;
        }
        return dp[0];
    }
}
