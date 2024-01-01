import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildrenfun(g, s));
    }
    static int findContentChildrenfun(int[] g, int[] s ){
        
        int count = 0;
       Arrays.sort(g);
       Arrays.sort(s);
       int i = 0, j= 0 ;
       while(i < g.length && j < s.length) {
           if(s[j] >= g[i]) {
               count++;
               i++;j++;
           } else {
               j++;
           }

       }
        return count;
    }
}
