// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

public class BestTimeToSellOrBuyIII {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int n = prices.length;
        int[][][]  dp =new int[n+1][2][3];
        int ans = memo(0, 1, 2, prices, dp);
        System.out.println(ans);
        System.out.println(maxProfit(prices));
        System.out.println(tabulation(prices));
        System.out.println(app2(0, 0, prices));
        int[][] dp1 = new int[n][4];
        System.out.println(app2Memo(0, 0, prices, dp1));
    }


    public static int maxProfit(int[] prices) {
       
       return f(0, 1, 2, prices);
    }
    public static int f(int ind, int buy,int cap,int[] prices){

        if (cap == 0 || ind == prices.length) {
            return 0;
        }

        if (buy == 1) {
            return Math.max(
                -prices[ind] + f(ind+1, 0, cap, prices),
                0 + f(ind+1, 1, cap, prices)
            );
        }
        else{
            return Math.max(
                prices[ind] + f(ind+1, 1, cap-1, prices),
                f(ind+1, 0, cap, prices)
            );
        }
    }

    public static int memo(int i,int buy,int cap,int[] prices,int[][][] dp){

        if (i == prices.length || cap == 0)  {
            return 0;
        }

        if (dp[i][buy][cap] != 0) {
            return dp[i][buy][cap];
        }

        if(buy == 1) {
            return dp[i][buy][cap] =   Math.max(
                        -prices[i] + memo(i+1, 0, cap, prices,dp),
                        memo(i+1, 1, cap, prices,dp)
                    );
        }
        return dp[i][buy][cap] =   Math.max(
                    prices[i] + memo(i+1, 1, cap-1, prices,dp),
                    memo(i+1, 0, cap, prices,dp)
                );
    }

    public static int tabulation(int[] prices){
        int n = prices.length;

        // Creating a 3D dp array of size [n+1][2][3] initialized to 0
        int[][][] dp = new int[n + 1][2][3];

        // Loop through the dp array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return dp[0][0][2];
    }



    public static int app2(int ind,int trans , int[] prices){

        if (ind == prices.length  || trans == 4) {
            return 0;
        }

        if (trans %2  == 0) {
            return  Math.max(-prices[ind] + app2(ind+1, trans+1, prices),app2(ind+1, trans, prices));
        }
        return  Math.max(prices[ind] + app2(ind+1, trans+1, prices), app2(ind+1, trans, prices));

    }

    public static int app2Memo(int i,int trans,int[] prices,int[][] dp){

        if (i == prices.length || trans == 4) {
            return 0;
        }
        if (dp[i][trans] != 0) {
            return dp[i][trans];
        }

        if (trans%2 ==0 ) {
            return dp[i][trans] = Math.max(-prices[i] + app2(i+1, trans+1, prices), app2(i+1, trans, prices));
        }
        return dp[i][trans] = Math.max(prices[i]+ app2Memo(i+1, trans+1, prices, dp), app2Memo(i+1, trans, prices, dp));
    }

    
}

