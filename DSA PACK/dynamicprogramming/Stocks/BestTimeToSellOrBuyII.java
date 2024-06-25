import java.util.Arrays;

public class BestTimeToSellOrBuyII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(tabulation(prices));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return f(0, 1, prices, 0,dp);

    }

    public static int f(int i,int buy,int[] prices,int profit,int[][] dp){

        if (i == prices.length) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        if (buy == 1) {
            profit = Math.max(
                 -prices[i]+ f(i+1, 0, prices, profit,dp), 
                    0+ f(i+1, 1, prices, profit,dp)
                );
        }else{
            profit = Math.max(
                prices[i]+ f(i+1, 1, prices, profit,dp), 
                    f(i+1, 0, prices, profit,dp)
               );
        }
        return dp[i][buy] =  profit;
    }

    public static int tabulation(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        // Initialize the entire dp table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Base condition: If we have no stocks to buy or sell, profit is 0
        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -prices[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], prices[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0]; 
    }
}