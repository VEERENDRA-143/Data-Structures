import java.util.Arrays;

public class MaxIceCreamsBars {
    public static void main(String[] args) {
        int[] costs = {1,6,3,1,2,5};
        int coins = 20;
        maxIceCream(costs, coins);
    }
    public static void maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            // sum+=costs[i];
            if ((coins-=costs[i] )< 0 ) {
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
