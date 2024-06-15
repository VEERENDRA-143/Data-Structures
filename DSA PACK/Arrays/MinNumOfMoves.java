import java.util.Arrays;

public class MinNumOfMoves {
    public static void main(String[] args) {
        int[] seats = {2,2,6,6};
        int[] students = {1,3,2,6};
        minMovesToSeat(seats, students);
    }
    public static void minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;

        for (int i = 0; i < students.length; i++) {
            sum += Math.abs(students[i]-seats[i]);
        }
        System.out.println(sum);
    }
}
