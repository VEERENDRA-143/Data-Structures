import java.util.ArrayList;
import java.util.List;

public class KthFactorOfInteger {
    public static void main(String[] args) {
        
        System.out.println(kthFactor(7,3));
    }
    public static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                list.add(i);
            }
        }
        return list.size()<k?-1:list.get(k-1);
    }
}
