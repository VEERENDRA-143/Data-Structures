import java.util.*;
public class MinNumOfStepsTomakeAnagram {
    public static void main(String[] args) {
        String s = "leetcode", t = "practice";
        String s1 = "bab", t1 = "aba";

        minSteps(s, t);
        // minSteps(s1, t1);
    }
    public static int minSteps(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (sMap.containsKey(c)) {
 
                sMap.put(c, sMap.get(c) + 1);
            }
            else {
 
                sMap.put(c, 1);
            }
        }

        Map<Character,Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (tMap.containsKey(c)) {
 
                tMap.put(c, tMap.get(c) + 1);
            }
            else {
 
                tMap.put(c, 1);
            }
        }

        System.out.println(sMap);
        System.out.println(tMap);

        for (char c : t.toCharArray()) {
            if (sMap.containsKey(c) && tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) - 1);
                sMap.put(c, sMap.get(c) - 1);
            }
            
        }
        System.out.println(sMap);
        System.out.println(tMap);
        int ans = 0;
        for (Map.Entry entry : sMap.entrySet()) {
            
            System.out.println(entry.getKey() + " " +entry.getValue());
            if ((int)entry.getValue() > 0) {
                ans +=(int)entry.getValue();
            }
                
        }
        System.out.println("ans = " + ans);
        
        return 0;
    }
}
