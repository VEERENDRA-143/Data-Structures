public class NoOfChangesTomakeEqual {
    public static void main(String[] args) {
        int n = 14, k = 13;
        System.out.println(minChanges(n, k));
    }
    public static int minChanges(int n, int k) {
        String nStr = binaryConvert(n);
        String kStr = binaryConvert(k);
        // System.out.println(nStr + " "+ kStr);
        int c =0 ;
        int len = (nStr.length() < kStr.length() ? nStr.length() : kStr.length());
        int diff = Math.abs(nStr.length() - kStr.length());

        for (int i = 0; i < len; i++) {
            if (nStr.charAt(i) != kStr.charAt(i)) {
                c++;
            }
        }
        return c+diff;
    }
    private static String binaryConvert(int n) {
        String ans = Integer.toBinaryString(n);
        
        System.out.println(ans);
        return ans;
    }
}
