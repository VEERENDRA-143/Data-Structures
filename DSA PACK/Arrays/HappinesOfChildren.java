import java.util.Arrays;

public class HappinesOfChildren {
    public static void main(String[] args) {
        int[] happiness = {1,2,3};
        int k = 2;
        maximumHappinessSum(happiness, k);
    }
    public static void maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int index = 0;

        for (int i = happiness.length-1; i >= happiness.length-k; i--) {
            // System.out.println(happiness[i]);
            int df = happiness[i]-index;
            if (df > 0) {
                sum+=df;
            }
            index++;
        }
        System.out.println(sum);
    }
}
