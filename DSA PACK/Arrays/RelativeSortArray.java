import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        relativeSortArray(arr1, arr2);
    }
    public static void relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i])+1);
            }
            else{
                map.put(arr1[i], 1);
            }
        }
        System.out.println(map);
        int[]  ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int c = map.get(arr2[i]);
            for (int j = index; j < index+c; j++) {
                ans[j]  =  arr2[i];
            }
            map.put(arr2[i], 0);
            index = index+c;
        }
        System.out.println(Arrays.toString(ans)+" "+index);
        System.out.println(map);

        for (Integer ele : map.keySet()) {
           if (map.get(ele) != 0 ) {
                int co = map.get(ele);
                for (int i = index; i < index+co; i++) {
                    ans[i] = ele;
                }
                index = index+co;
           } 
        }
        System.out.println(Arrays.toString(ans));
    }
}
