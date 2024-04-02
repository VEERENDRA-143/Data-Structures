import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        reverseString(s);
    }
    public static void reverseString(char[] s) {
        int start=0;
        int end = s.length-1;
        while (start<=end) {
            char ch = s[start];
            s[start] = s[end];
            s[end] = ch;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }
}
