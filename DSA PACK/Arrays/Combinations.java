import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        combine(n, k);  
    }
     public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(1, comb, res, n, k);
        return res;
    }

    private static void backtrack(int start, List<Integer> comb, List<List<Integer>> res, int n, int k) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int num = start; num <= n; num++) {
            System.out.println(comb.add(num));
            backtrack(num + 1, comb, res, n, k);
            System.out.println(comb.remove(comb.size() - 1));
        }
    } 
}
