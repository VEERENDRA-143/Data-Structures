import java.util.*;
public class CountSubStringsEveryVowel {
    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k =1;
        countSubStrings(word, k);
    }
    public static void countOfSubstrings(String word, int k) {
        int n = word.length();

        if ( word.indexOf('a') < 0 || word.indexOf('e') < 0 || word.indexOf('i') < 0
        || word.indexOf('o') < 0 || word.indexOf('u') < 0 || n < 5) {
            System.out.println(0);
            return;
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            int a = 0,e=0,ic=0,o =0,u=0,consonents=0;
            for (int j = i; j < n; j++) {
                if (word.charAt(j) == 'a') a++;
                else if (word.charAt(j) == 'e') e++;
                else if (word.charAt(j) == 'i') ic++;
                else if (word.charAt(j) == 'o') o++;
                else if (word.charAt(j) == 'u') u++;
                else consonents++;
                if (a> 0 && e > 0 && ic > 0 && o >0 && u > 0 && consonents == k ) {
                    ans++;
                }
            }

            
        }
        System.out.println(ans);

    }

    public static void countSubStrings(String w, int k){
        int n = w.length();
        int left = 0;
        int right = 0;

        Map<Character,Integer> map = new HashMap<>();
        int consonents=0;
        int ans= 0;
        while (right < n) {
            if (w.charAt(right) == 'a' || w.charAt(right) == 'e' || w.charAt(right) == 'i' ||
                w.charAt(right) == 'o' || w.charAt(right) == 'u'){
                map.put(w.charAt(right), map.getOrDefault(w.charAt(right), 0)+1);
            }
            else{
                consonents++;
            }

            if (consonents > k) {
                while (left < right) {
                    char c = w.charAt(left);
                    map.put(c, map.getOrDefault(c,0)-1);
                    if (!map.containsKey(c)) {
                        map.remove(c);
                    }
                    left++;
                }
            }
            boolean check = checkValidSubString(map,consonents,k);
            if (check) {
                ans++;
            }
            right++;
        }
        System.out.println(ans);
    }
    private static boolean checkValidSubString(Map<Character, Integer> map, int consonents, int k) {
        if (consonents != k) {
            return false;
        }

        char[] vowels = {'a','e','i','o','u'};
        for (char c : vowels) {
            
            if (!map.containsKey(c)) {
                return false;
            }
            
        }

        return true;
    }
}

