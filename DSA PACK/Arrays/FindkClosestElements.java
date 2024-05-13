import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindkClosestElements {
    public static void main(String[] args) {
        int[] arr={0,0,1,2,3,3,4,7,7,8};
        int k=3;
        int x = 3;
        findClosestElements(arr, k, x);
    }
    public static void findClosestElements(int[] arr, int k, int x) {
       
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            map.put(diff, i);
        }

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        int i=0;
        while (k != 0) {
            System.out.println(arr[sortedMap.get(i)]);
            i++;
            k--;
        }

    }
    

}
