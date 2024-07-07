// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/

import java.util.*;
public class GenarateStrings {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(validStrings(n));
    }

    public static List<String> validStrings(int n) {
        StringBuilder sb= new StringBuilder();
        List<String> ans = new ArrayList<>();
        f(-1, n, sb, ans);
        return ans;
    }
    public static void f(int ind, int n,StringBuilder sb,List<String> ans){

        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }

        sb.append('1');
        f(1, n, sb, ans);
        sb.deleteCharAt(sb.length()-1);

        if (ind != 0) {
            sb.append('0');
            f(0, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
