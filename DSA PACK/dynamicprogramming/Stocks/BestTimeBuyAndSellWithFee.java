import java.util.Arrays;

public class BestTimeBuyAndSellWithFee {
    public static void main(String[] args) {
        int[] prices ={1,3,7,5,10,3};
        int fee = 3;
        System.out.println("ta = "+ tabulation(prices, fee));
        System.out.println(maxProfit(prices, fee));
        
    }
    public static int maxProfit(int[] prices,int fee){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        System.out.println(mem(0, 1, prices, fee, dp));
        return f(0, 1, prices, fee);
    }
    public static int f(int ind,int buy,int[] prices,int fee){

        if (ind == prices.length) {
            return 0;
        }

        if (buy ==1) {
            return Math.max(
                -prices[ind] + f(ind+1, 0, prices,fee),
                f(ind+1, 1, prices,fee)
            );
        }
        return Math.max(
            prices[ind] - fee  + f(ind+1, 1, prices,fee),
            f(ind+1, 0, prices,fee)
        );
    }


    public static int mem(int ind,int buy,int[] prices,int fee,int[][] dp){

        if (ind >= prices.length) {
            return 0;
        }
        if (dp[ind][buy] != 0) {
            return dp[ind][buy];
        }
        if (buy == 1) {
            return dp[ind][buy] = Math.max(
                -prices[ind] + mem(ind+1, 0, prices, fee, dp),
                mem(ind+1, 1, prices, fee, dp)
            );
        }
        return dp[ind][buy] = Math.max(
            prices[ind] - fee + mem(ind+1, 1, prices, fee, dp),
            mem(ind+1, 0, prices, fee, dp)
        );
    }
    public static int tabulation(int[] prices,int fee){

        int n  = prices.length;
        int[][] dp = new int[n+1][2];
        for (int i = n-1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[i][buy] = Math.max(
                        -prices[i] + dp[i+1][0], 
                        dp[i+1][1]
                    );
                }
                else{
                    dp[i][buy] = Math.max(
                        prices[i] - fee + dp[i+1][1],
                        dp[i+1][0]
                    );
                }
                 
            }
        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return dp[0][1];
     }
}
