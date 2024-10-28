import java.util.ArrayList;
import java.util.List;

public class KthSmallestInLexograhical {
    public static void main(String[] args) {
        int n = 13;
        int  k = 2;
        findKthNumber(n, k);
    }
    public static void findKthNumber(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int start = 1; start <= 9; start++) {
            f(start,n,res);
        }
        System.out.println(res);
        System.out.println(res.get(k-1));
    }
    private static void f(int currNum, int n, List<Integer> res) {

        if (currNum > n) {
            return;
        }
        res.add(currNum);
        for (int i = 0; i <= 9; i++) {
            int nextNum = currNum*10 + i;
            if (nextNum <= n) {
                f(nextNum,n,res);
            }else{
                break;
            }
        }
    }
}
