public class BestTimeToBuySellStockIV {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
        System.out.println(tabulation(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][3][k+1];
        System.out.println("memo = " + memo(0, 1, k, prices, dp));

        return f(0, 1, k, prices);

    }

    public static int f(int ind,int buy,int cap,int[] prices){

        if (ind == prices.length || cap == 0) { 
            return 0;
        }

        if (buy  == 1) {
            return Math.max( 
                -prices[ind] + f(ind+1, 0, cap, prices),
                0 + f(ind+1, 1, cap, prices)
            );
        }
        return Math.max(
            prices[ind] + f(ind+1, 1, cap-1, prices),
            0 + f(ind+1, 0, cap, prices)
        );

    }

    public static int memo(int i,int buy,int cap,int[] prices,int[][][] dp){

        if (i == prices.length || cap == 0) {
            return 0;
        }

        if (dp[i][buy][cap] != 0) {
            return dp[i][buy][cap];
        }

        if (buy == 1) {
            return dp[i][buy][cap] = Math.max(
                -prices[i] + memo(i+1, 0, cap, prices, dp),
                0 + memo(i+1, 1, cap, prices, dp)
            );
        }
        return dp[i][buy][cap]= Math.max(
            prices[i] + memo(i+1, 1, cap-1, prices, dp),
            0 + memo(i+1, 0, cap, prices, dp)
        );

    }

    public static int tabulation(int k,int[] prices){
        int n = prices.length;
        int[][][] dp =new int[n+1][3][k+1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], 
                                -prices[ind] + dp[ind + 1][1][cap]);
                    } else { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}
