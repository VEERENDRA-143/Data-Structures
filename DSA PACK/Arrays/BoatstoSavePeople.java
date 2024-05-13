import java.util.Arrays;

public class BoatstoSavePeople {
    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 5;
        numRescueBoats(people, limit);
    }
    
    public static void numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats=0;
        int start=0;
        int end = people.length-1;

        while(start <= end) {
            if (people[start]+people[end] <= limit) {
                start++;
            }
            end--;
            boats++;

        }

        System.out.println(boats);
    }

}
