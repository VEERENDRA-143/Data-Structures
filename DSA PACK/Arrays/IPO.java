import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IPO {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        findMaximizedCapital(k, w, profits, capital);
    }
    public static void findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        HashMap<Integer,Integer> map = new HashMap<>();
        findMincaptial(capital,k,map);

        for (int ele : map.keySet()) {
            w += profits[map.get(ele)];
        }
        System.out.println(w);
    }
    private static void findMincaptial(int[] capital,int k,HashMap<Integer,Integer> map) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            list.add(capital[i]);
        }
        System.out.println(list);
        Arrays.sort(capital);
        System.out.println(Arrays.toString(capital));
        for (int i = 0; i < k; i++) {
            if (!map.containsKey(capital[i])) {
                map.put(capital[i], list.lastIndexOf(capital[i]));
            }
        }
        
    }
}
