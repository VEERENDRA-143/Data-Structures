
public class SikpCharecter {

    public static void main(String[] args) {
        System.out.println(WithRecurion("aavwnnmqzaaknk", ""));
        System.out.println(WithRecurion_String("aavwnnmqzaaknk"));
    }

    // Approch - 1
    static void PrintSkip(String ori, String ans) {
        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) == 'a') {
                continue;
            } else {
                ans += ori.charAt(i);
            }
        }

        System.out.println(ans);
    }

    // Approch - 2
    static String WithRecurion(String ori, String ans) {
        if (ori.isEmpty()) {
            return ans;
        }
        
        char ch = ori.charAt(0);

        if (ch == 'a') {
            return WithRecurion(ori.substring(1), ans);
        }
        return WithRecurion(ori.substring(1), ans + ch);
    }

    // Approch - 3
    static String WithRecurion_String(String ori) {
        if (ori.isEmpty()) {
            return "";
        }

        char ch = ori.charAt(0);

        if (ch == 'a') {
            return WithRecurion_String(ori.substring(1));
        }
        return ch + WithRecurion_String(ori.substring(1));
    }

}