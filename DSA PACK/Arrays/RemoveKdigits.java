import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "10001";
        int k = 4;
        System.out.println(removeKdigits(num, k));
    }
    public static String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        
        String ans = "";
        int reqsize = num.length()-k;
        int i=0;
        int j=1;
        if (num.length()==2 && k<num.length()) {
            ans+= (num.charAt(i)<=num.charAt(j))?num.charAt(i):num.charAt(j);
            return ans;
        }
        if (num.charAt(i)<=num.charAt(j)) {
            ans+=num.charAt(i);
        }
        while (k!=0) {
            
            if (num.charAt(i)<=num.charAt(j) && num.charAt(j)<=num.charAt(j+1) && (j+1)<=num.length()-1) {
                ans+=num.charAt(i);
            }
            i++;
            j++;
            k--;
        }
        while (j != num.length() && ans.length()<reqsize) {
            ans+=num.charAt(j);
            j++;
        }
        
        int a=0;
        if (ans.charAt(0)=='0'&&ans.charAt(ans.length()-1)!='0') {
            while (ans.charAt(a)=='0') {
                a++;
            }
        }
        ans = ans.substring(a, ans.length());
        return ans;
    }
}
