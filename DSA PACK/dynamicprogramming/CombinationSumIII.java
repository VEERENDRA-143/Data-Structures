import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3, n = 7;
        combinationSum3(k, n);
    }

    public static void combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        findCombinations(1, k, n, ans, new ArrayList<>(), 0);

        System.out.println(ans);
    }

    public static void findCombinations(int index, int k, int n, List<List<Integer>> ds, List<Integer> list, int sum) {
        if (sum == n) {
            if (list.size() == k) {

                ds.add(new ArrayList<>(list));

            }
            return;
        }
        if (index > 9) {
            if (sum == n && list.size() == k) {

                ds.add(new ArrayList<>(list));

            }
            return;
        }

        sum += index;
        list.add(index);
        findCombinations(index + 1, k, n, ds, list, sum);

        sum -= index;
        list.remove(list.size() - 1);
        findCombinations(index + 1, k, n, ds, list, sum);

    }
}
