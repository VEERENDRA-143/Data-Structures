import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 0 || s.length() < k) {
            return s;
        }

        if (s.startsWith("abcdefghijklmnopqrstuvwxyz")) {
            return "";
        }

        char c = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                c = s.charAt(i);
                count = 1;
            }

            if (count == k) {
                return removeDuplicates(s.substring(0, i - k + 1) + s.substring(i + 1), k);
            }
        }
        return s;

    }
}