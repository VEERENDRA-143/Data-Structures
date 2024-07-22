import java.util.*;
public class MinLengthofStringAfterRemovel {
    public static void main(String[] args) {
        String  s = "aa";
        minimumLength(s);
    }
    public static int minimumLength(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char  c: s.toCharArray()) {
            if (map.containsKey(c)) {
                
                map.put(c, map.get(c) + 1);
            }
            else {
 
                map.put(c, 1);
            }
        }
        int ans = 0;
       for (Map.Entry<Character, Integer>  entry : map.entrySet()) {
            int f = entry.getValue();
            ans += (f%2 ==1) ? f-1 : f-2;
       }
       System.out.println(s.length()-ans);
       return s.length()-ans;
    }
}
