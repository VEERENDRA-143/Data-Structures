import java.util.ArrayList;

public class EliminationGame {
    public static void main(String[] args) {
        int n= 9;
        lastRemaining(n);
    }
    public static void lastRemaining(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean isEven = true;
        int ind = 1;
        while (list.size() != 1) {
            if (isEven) {
                while (ind != n+1) {
                    list.remove(ind);
                    ind+=2;
                }
                ind = list.get(0);
            }else{
                list.remove(ind+1);
                ind+=2;
            }
            isEven = !isEven;
        }
        System.out.println(list);
    }
    
}
