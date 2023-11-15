import java.util.ArrayList;
import java.util.List;

public class CountPairsLessThanTarget {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        // List<Integer> l = {-1,1,2,3,1};
        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(countPairs(list, 9));
    }

    static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (i != j) {
                    if (nums.get(i) + nums.get(j) < target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
