import java.util.*;
public class RobotCollisions {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {2,17,9,15,10};
        String directions = "RRRRR";
        survivedRobotsHealths(positions, healths, directions);
    }
    public static void survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int max = findMax(positions);
        int[] robots = new int[max+1];

        for (int i = 0; i < positions.length; i++) {
            robots[positions[i]] = i+1;
        }
        
        System.out.println(Arrays.toString(robots));

    }

    public static int findMax(int[] array){
        return 6;
    }
}
