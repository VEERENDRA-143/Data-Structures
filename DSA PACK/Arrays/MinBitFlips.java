public class MinBitFlips {
    public static void main(String[] args) {
        int start=10;
        int goal = 7;
        minBitFlips(start, goal);
    }
    public static void minBitFlips(int start, int goal) {
        String s1 = decTobin(start);
        String s2 = decTobin(goal);
        int count = 0;
        int n = s1.length() <= s2.length() ? s1.length() : s2.length(); 
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
    private static String decTobin(int start) {
        String ans = "";
        while (start != 0) {
            int rem = start%2;
            ans += rem;
            start /=2;
        }
        return ans;
    }
}
