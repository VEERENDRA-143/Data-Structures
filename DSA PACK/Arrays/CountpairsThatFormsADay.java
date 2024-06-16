import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountpairsThatFormsADay {
    public static void main(String[] args) {
        int[] hours = { 72, 48, 24, 3 };
        // countCompleteDayPairs(hours);
        method2(hours);
    }

    public static void countCompleteDayPairs(int[] hours) {
        int count = 0;
       for (int i = 0; i < hours.length; i++) {
            for (int j = i+1; j < hours.length; j++) {
                if ((hours[i]+hours[j])%24 == 0) {
                    count++;
                }
            }
       }
        System.out.println(count);
    }
    public static void method2(int[] hours){
        int ans = 0;
        int[] count = new int[24];
        for (int hour : hours) {
            int exp = (24 - hour%24)%24;
            ans += count[exp];
            count[hour%24]++;
        }
        System.out.println(ans);
    }
}
