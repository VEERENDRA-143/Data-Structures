public class ScoreOfString {
    public static void main(String[] args) {
        String s = "zaz";
        scoreOfString(s);
    }
    public static void scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            // System.out.println((int)s.charAt(i));
            int first = (int)s.charAt(i);
            int second = (int)s.charAt(i+1);
            System.out.println(Math.abs(first-second));
            sum+=Math.abs(first-second);
        }
        System.out.println(sum);
    }
}
