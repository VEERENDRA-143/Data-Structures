import java.util.Arrays;

public class DailyTemprature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
        double celsius = 122.11;
        converTemprature(celsius);

    }
    public static void dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < ans.length; i++) {
            int nexttemp = findGreatest(temperatures,temperatures[i],i+1);
            ans[i] = nexttemp;
        }

        System.out.println(Arrays.toString(ans));
    }
    private static int findGreatest(int[] temperatures, int num, int j) {
        int nexttemp=1;
        for (int i = j; i < temperatures.length; i++) {
            if (num>=temperatures[i]) {
                nexttemp++;
            }
           else {
                return nexttemp;
            }
        }
        return 0;
    }

    // Leet Code : 2469
    public static void converTemprature(double celsius){
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius* 1.80 + 32.00;
        System.out.println(Arrays.toString(ans));
    }
}
