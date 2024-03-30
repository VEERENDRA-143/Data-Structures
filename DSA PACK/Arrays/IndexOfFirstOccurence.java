public class IndexOfFirstOccurence {
    public static void main(String[] args) {
        String haystack = "sadbutsadtr";
        String needle = "sade";
        System.out.println(strStr(haystack, needle));
    }
    public static int strStr(String haystack, String needle) {
        for (int i = 0,j=needle.length(); i < haystack.length(); i++,j++) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
