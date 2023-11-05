public class SkipString {

    public static void main(String[] args) {
        System.out.println(SkipAppNotApple("bccapplecappdh", "apple"));
    }

    static String skip_str(String s, String substr) {
        if (s.isEmpty()) {
            return "";
        }

        if (s.startsWith(substr)) {
            return skip_str(s.substring(substr.length()), substr);
        }
        return s.charAt(0) + skip_str(s.substring(1), substr);
    }


    static String SkipAppNotApple(String s, String substr) {
        if (s.isEmpty()) {
            return "";
        }

        if (s.startsWith("app") && !s.startsWith(substr)) {
            return SkipAppNotApple(s.substring("app".length()), substr);
        }
        return s.charAt(0) + SkipAppNotApple(s.substring(1), substr);
    }
}