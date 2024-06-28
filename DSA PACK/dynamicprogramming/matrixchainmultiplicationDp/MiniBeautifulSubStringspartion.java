public class MiniBeautifulSubStringspartion {
    public static void main(String[] args) {
        String s = "1011";
        System.out.println(minimumBeautifulSubstrings(s));
    }
    public static int minimumBeautifulSubstrings(String s) {
        return f(0, s);
    }

    public static int f(int i,String s){


        if ( i == s.length()) {
            return 0;
        }
        if (s.charAt(i) == '0') {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int j = i; j < s.length(); j++) {
            val = val*2 + (s.charAt(j)-'0');
            if (isPowerFive(val)) {
                int res = f(j+1, s);
                if (res != -1) {
                    min = Math.min(min, res+1);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
    private static boolean isPowerFive(int num) {
        int modulo = 0;
        while (modulo == 0 && num > 1) {
            modulo = num % 5;
            num = num / 5;
        }
        return num == 1 && modulo == 0;
    }
}
