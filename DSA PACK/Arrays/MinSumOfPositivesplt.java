import java.util.List;

public class MinSumOfPositivesplt {
    public static void main(String[] args) {
        long finalSum = 28;
        maximumEvenSplit(finalSum);
    }
    public static void maximumEvenSplit(long finalSum) {
        int sum = 0;
        for (int i = 1; i <= finalSum; i++) {
            if (i%2 == 0) {
                // System.out.print(i+" ");
                
                if (sum <= finalSum) {
                    
                    System.out.print(i+" ");
                }
                sum+=i;
            }
        }
    }
}
