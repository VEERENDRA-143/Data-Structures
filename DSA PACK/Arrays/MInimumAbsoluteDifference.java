import java.util.ArrayList;
import java.util.List;

public class MInimumAbsoluteDifference {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        // nums.add(15);
        int x = 3;
        minAbsoluteDifference(nums, x);
    }
    public static void minAbsoluteDifference(List<Integer> nums, int x) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+x ; j < nums.size(); j++) {
                int absDiff = Math.abs(nums.get(i)-nums.get(j));
                min = Math.min(min, absDiff);
            }
        }
        System.out.println(min);
    }
}
