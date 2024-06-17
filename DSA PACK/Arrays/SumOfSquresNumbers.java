public class SumOfSquresNumbers {
    public static void main(String[] args) {
        int c = 5;
        System.out.println(approch2(c));
    }
    public static boolean judgeSquareSum(int c) {
        for (long a = 0; a*a < c; a++) {
            int b = c - (int)(a*a);
            if (binarysearch(0,b,b)) {
                return true;
            }
        }
        return false;
    }
    private static boolean binarysearch(long start, long end, int b2) {
        if (start>end) {
            return false;
        }
        long mid = (start+end) /2;      
        if (mid*mid == b2) {
            return true;
        }

        if (mid*mid > b2) {
            return binarysearch(start, mid-1, b2);
        }
        return binarysearch(mid+1, end, b2);
    }   

    public static boolean approch2(int c){
        long b = (int)(Math.sqrt(c));
        long a = 0;
        while (a <= b) {
            long val = a*a + b*b;
            if (val == c) {
                return true;
            }
            else if (val > c) {
                b--;
            }
            else{
                a--;
            }
        }
        return false;
    }
}
