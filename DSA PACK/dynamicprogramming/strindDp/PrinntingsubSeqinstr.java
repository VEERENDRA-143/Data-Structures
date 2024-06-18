package strindDp;

import java.util.ArrayList;
import java.util.List;

public class PrinntingsubSeqinstr {
    public static void main(String[] args) {
        String s = "abc";
        getSubseq(s);
    }
    public static void getSubseq(String s){

        List<String> ans = new ArrayList<>();
        
        findSeq(0,s,ans,"");
        System.out.println(ans);
    }
    private static void findSeq(int n, String s, List<String> list,String p) {
        
        if (n > s.length()-1) {
            list.add(p);
            return;
        }

        p += s.charAt(n);

        findSeq(n+1, s, list, p);

        p = p.substring(0, p.length()-1);
        
        findSeq(n+1, s, list, p);
    }
}
