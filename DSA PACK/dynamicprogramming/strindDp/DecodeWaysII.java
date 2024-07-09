public class DecodeWaysII {

    int M = (int)1e9;
    public static void main(String[] args) {
        String s = "*";
        DecodeWaysII o =new DecodeWaysII();
        System.out.println(o.numDecodings(s));
    }
    public int numDecodings(String s) {
        
        int n = s.length();
        return f(n-1, s);
    }

    public int f(int ind,String s){

        if (ind <0) {
            return 1;
        }

        if (s.charAt(ind) == '*') {

            long res = 9* f(ind-1, s) % M;

            if (ind > 0 && s.charAt(ind-1) == '1' ) {
                res += (9* f(ind-2, s))%M;
            }else if (ind >0  && s.charAt(ind-1) == '2') {
                res += (6* f(ind-2, s)) % M;
            }else if (ind > 0 && s.charAt(ind-1) == '*') {
                res +=  (15* f(ind-2, s)) % M;
            }

            return (int)res % M;
        }

        long res = s.charAt(ind) != '0' ? f(ind-1, s) % M: 0;

        if (ind > 0 && s.charAt(ind-1) == '1' ) {
            res =( res + f(ind-1, s)) % M;
        }else if (ind >0  && s.charAt(ind-1) == '2' && s.charAt(ind ) <= '6') {
            res = (res+ f(ind-2, s)) % M;
        }else if (ind > 0 && s.charAt(ind-1) == '*') {
            res = (res+  (s.charAt(ind) <= '6' ? 2 :1 ) +  f(ind-2, s)) % M;
        }

        return (int)res%M;
    }
}
