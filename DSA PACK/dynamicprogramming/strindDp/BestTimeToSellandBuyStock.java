public class BestTimeToSellandBuyStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        findMaxprofit(prices);
    }

    public static void findMaxprofit(int[] prices){
        int mini = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(prices[i], mini);
        }
        System.out.println(profit);
    }
}
