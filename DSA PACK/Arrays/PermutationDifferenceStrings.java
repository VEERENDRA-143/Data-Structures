public class PermutationDifferenceStrings {
    public static void main(String[] args) {
        String s = "abc";
        String t = "bac";
        findPermutationDifference(s, t);
    }
    public static void findPermutationDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum+=Math.abs(i-t.indexOf(s.charAt(i)));
        }

    }
}
