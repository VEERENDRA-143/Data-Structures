public class BoleanEvaluationToTrue {
    public static void main(String[] args) {
        String exp = "&FT";
        System.out.println(evaluateExp(exp));
    }
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        return (int)f(0, n-1, 1, exp);
    }
    
    public static long f(int i,int j,int isTrue,String exp){
        if (i > j) {
            return 0;
        }
        if ( i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1:0;
            }else{
                return exp.charAt(i) == 'F' ? 1:0;
            }
        }

        long ways = 0;

        for (int k = i+1; k <= j-1; k += 2) {
            long lT = f(i, k-1, 1, exp);
            long lF = f(i, k-1, 0, exp);
            long rT = f(k+1, j, 1, exp);
            long rF = f(k+1, j, 0, exp);

            if (exp.charAt(k) == '&') {
                if (isTrue == 1) {
                    ways += lT*rT;
                }else{
                    ways += (lT*rF) + (lF*rT) + (rF*lF);
                }
            }
            else if (exp.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways += (lF*rT) + (lT * rF) + (lT * rT);
                }else{
                    ways += (lF*rF);
                }
            }
            else{
                if (isTrue == 1) {
                    ways += (lT*rT) +(lT*rF);
                }
                else{
                    ways += (lF*rF) + (lT* rT);
                }
            }
        }
        return ways;
    }
}
