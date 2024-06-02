import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDaysWithoutMeetings {
    public static void main(String[] args) {
        int days = 8;
        int[][] meetings = {
            {3,4},
            {4,8},
            {2,5},
            {3,8},
        };
        System.out.println(countDays2(days, meetings));
    }
    public static void countDays(int days, int[][] meetings) {
        // ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> hash_Set = new HashSet<Integer>(); 
        int count = 0;

        for (int[] row : meetings) {
            for (int i = row[0]; i <= row[1]; i++) {
                hash_Set.add(i);
            }
        }
        System.out.println(hash_Set);
        System.out.println(days - hash_Set.size());
    }
    

    public static int countDays2(int days, int[][] meetings) {
        Arrays.sort(meetings, (o, p) -> o[0] - p[0]);
        int curr = 0, count = 0;
        for (int[] meeting : meetings) {
            count += Math.max(0, meeting[0] - curr - 1);
            curr = Math.max(curr, meeting[1]);
        }
        return count + days - curr;
    }
}
