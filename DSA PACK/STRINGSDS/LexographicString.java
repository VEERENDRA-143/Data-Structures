

public class LexographicString {
    public static void main(String[] args) {
        String s = "dabdaddace";
        int n = s.length();
        int k = 8;
        System.out.println(createString(n, k, s));

    }
    public static String createString(int n, int k, String s) {
        String str="";
        int count=0;
        for (int i = 0; i <  s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)) {
                    count++;
                }
            }
            if (count==k) {
                for (int m = 0; m < k; m++) {
                    str = str+s.charAt(i);
                }
            }
            count=0;
        }
        return str;
    }
}

// if (s.charAt(p1) == s.charAt(p2)) {
//     str=str+s.charAt(p1);
//     str=str+s.charAt(p2);
//     p1++;
//     p2++;
// }
// else{
//     p1++;
//     p2++;
// }