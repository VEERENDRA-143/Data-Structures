import java.util.*;
class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (eql(nums[i], nums[j])) {
                    
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean eql(int x, int y) {
        System.out.println(x + " " + y);
        int[] a1 = arr(x);
        int[] a2 = arr(y);
        int[] mis = new int[4];

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            if (a1[k] != a2[k]) {
                if (cnt == 4)
                    return false;
                mis[cnt] = k;
                cnt++;
            }
        }
        System.out.println(Arrays.toString(mis));

        if (cnt == 0)
            return true;
        else if (cnt == 2) {
            return a1[mis[0]] == a2[mis[1]] && a1[mis[1]] == a2[mis[0]];
            
        } else if(cnt==3){
            int a=mis[0];
            int b=mis[1];
            int c=mis[2];
            return (a1[a]==a2[b] && a1[b]==a2[c]&& a1[c]==a2[a])||(a1[a]==a2[c] && a1[c]==a2[b]&& a1[b]==a2[a]);
        }
        else if (cnt == 4) {
            int a=mis[0];
            int b=mis[1];
            int c=mis[2];
            int d=mis[3];
            return(a1[a]==a2[b]&& a1[b]==a2[a] && a1[c]==a2[d]&& a1[d]==a2[c])||
                  (a1[a]==a2[c]&& a1[c]==a2[a] && a1[b]==a2[d]&& a1[d]==a2[b])||
                  (a1[a]==a2[d]&& a1[d]==a2[a] && a1[b]==a2[c]&& a1[c]==a2[b]);
        } else {
            return false;
        }
    }

    public static int[] arr(int num) {
        int[] cnt = new int[8];
        int i = 0;
        while (num > 0) {
            cnt[i] = num % 10;
            num /= 10;
            i++;
        }
        return cnt;
    }
}
public class CountAlmostII {

    public static void main(String[] args) {
        Solution  s = new Solution();
        int[] nums = {1023,2310,2130,213};
        // System.out.println(s.countPairs(nums));
        System.out.println(countPairs(nums));
    }
    public static int countPairs(int[] nums) {
        int cnt = 0;
        for(int i = 0 ;i < nums.length; i++){
            for(int j = i+1 ; j < nums.length;j++){
                boolean check = checkEquality(nums[i],nums[j]);
                if(check){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean checkEquality(int n,int m){
        String s1 = String.valueOf(n);
        String s2 = String.valueOf(m);

        while(s1.length() < s2.length()){
            s1 = "0"+s1;
        }
        while(s2.length() < s1.length()){
            s2 = "0"+s2;
        }

        int noOfMisMatches = 0;
        int first = -1;
        int second = -1;
        int third = -1;
        int fourth = -1;

        for(int i =0;i < s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                noOfMisMatches++;
                if(noOfMisMatches == 1){
                    first = i;
                }else if(noOfMisMatches ==2){
                    second = i;
                }else if(noOfMisMatches == 3){
                    third = i;
                }else if(noOfMisMatches == 4){
                    fourth = i;
                }else{
                    return false;
                }
            }
        }

        if(noOfMisMatches == 1){
            return s1.equals(s2);
        }
        if(noOfMisMatches == 2){
            char[] sa2 = s2.toCharArray();
            char ch = sa2[first];
            sa2[first] = sa2[second];
            sa2[second] = ch;
            s2 = new String(sa2);
            return s1.equals(s2);
        }
        if(noOfMisMatches == 3){
            char[] sa1 = s1.toCharArray();
            char[] sa2 = s2.toCharArray();
            
            return (sa1[first] == sa2[second] && sa1[second] == sa2[third] && sa1[third] == sa2[first] || 
                    sa1[first] == sa2[third] && sa1[third] == sa2[second] && sa1[second] == sa2[first]);
        }
        if(noOfMisMatches == 4){
            
            return( (s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first)&& s1.charAt(third) == s2.charAt(fourth) && s1.charAt(fourth) == s2.charAt(third))||
                    (s1.charAt(first) == s2.charAt(third) && s1.charAt(third) == s2.charAt(first) && s1.charAt(second) == s2.charAt(fourth) && s1.charAt(fourth) == s2.charAt(second))||
                    (s1.charAt(first) == s2.charAt(fourth) && s1.charAt(fourth) == s2.charAt(first) && s1.charAt(third) == s2.charAt(second) && s1.charAt(second) == s2.charAt(third)));
        } 
        return false;
    }
}