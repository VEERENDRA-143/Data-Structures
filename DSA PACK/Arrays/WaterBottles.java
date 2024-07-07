public class WaterBottles {
    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0;
        while (numBottles >= numExchange) {
            System.out.println(numBottles);
            int quient = numBottles / numExchange;
            sum += numExchange * quient;
            numBottles -= numExchange * quient;
            numBottles += quient;
        }
        return sum + numBottles;
    }
}
