import java.util.*;
public class NumberOfUniqueSubSequence {
    public static void main(String[] args) {
        String s = "aaa";
        Set<String> ans = new HashSet<>();
        genSubSeq(0, s, "", ans);
        
        System.out.println(ans);
    }
    public static void genSubSeq(int i,String s,String p,Set<String> ans){
        if (i >= s.length()) {
            
            // if (p.isEmpty() ||  p.charAt(0) == '0' && p.length()>=2 ) {
            //     return;
            // }
            ans.add(p);
            return;
        }   

        p += s.charAt(i);
        genSubSeq(i+1, s, p, ans);
        p = p.substring(0,p.length()-1);
        genSubSeq(i+1, s, p, ans);
    }
}
