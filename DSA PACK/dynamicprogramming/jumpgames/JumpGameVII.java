public class JumpGameVII {
    public static void main(String[] args) {
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;
        System.out.println(canReach(s, minJump, maxJump));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        return f(0, minJump, maxJump, s);
    }

    public static boolean f(int ind, int minJump, int maxJump, String s) {

        if (ind < 0 || ind > s.length() - 1) {
            return false;
        }
        if (s.charAt(ind) == '0') {
            return true;
        }

        for (int j = minJump + 1; j <= Math.min(ind + maxJump, s.length() - 1); j++) {

            boolean check = f(j, minJump, maxJump, s);
            if (check) {
                return true;
            }
        }
        return false;
    }

    public boolean tabulation(String s, int minJump, int maxJump) {
        int n = s.length(), available = 0;
        if(s.charAt(n - 1) == '1') return false;
        
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for(int i = 1; i < n; i++) {
            if(i >= minJump) available += dp[i - minJump] ? 1 : 0;
            if(i > maxJump) available -= dp[i - maxJump - 1] ? 1 : 0;
            
            dp[i] = available > 0 && s.charAt(i) == '0';
        }
        
        return dp[n - 1];
    }
}
