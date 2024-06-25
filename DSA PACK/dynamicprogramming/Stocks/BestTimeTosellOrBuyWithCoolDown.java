// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimeTosellOrBuyWithCoolDown {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };

        System.out.println(maxProfit(prices));
        System.out.println("tab = " + tabulation(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        return memo(0, 1, prices, dp);
    }

    public static int f(int ind, int buy, int[] prices) {

        if (ind >= prices.length) {
            return 0;
        }

        if (buy == 1) {
            return Math.max(
                    -prices[ind] + f(ind + 1, 0, prices),
                    0 + f(ind + 1, 1, prices));
        }
        return Math.max(
                prices[ind] + f(ind + 2, 1, prices),
                0 + f(ind + 1, 0, prices));
    }

    public static int memo(int i, int buy, int[] prices, int[][] dp) {

        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buy] != 0) {
            return dp[i][buy];
        }

        if (buy == 1) {
            return dp[i][buy] = Math.max(
                    -prices[i] + memo(i + 1, 0, prices, dp),
                    0 + memo(i + 1, 1, prices, dp));
        }
        return dp[i][buy] = Math.max(
                prices[i] + memo(i + 2, 1, prices, dp),
                0 + memo(i + 1, 0, prices, dp));
    }

    public static int tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[i][buy] = Math.max(
                            -prices[i] + dp[i + 1][0],
                            dp[i + 1][1]);
                } else {
                    if (i + 2 < n) {
                        dp[i][buy] = Math.max(
                                prices[i] + dp[i + 2][1],
                                dp[i + 1][0]);
                    } 

                }
            }
        }
        return dp[0][0];
    }
}
