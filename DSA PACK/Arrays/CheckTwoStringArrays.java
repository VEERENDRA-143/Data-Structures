public class CheckTwoStringArrays {
    public static void main(String[] args) {
        String[] word1={"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        System.out.println(check(word1, word2));
    }
    static boolean check(String[] word1,String[] word2 ){
        String s1 = "";
        String s2 = "";

        if (word1.length <=1 && word2.length<=1) {
            return word1[0].equals(word2[0]);
        }

        if (word1.length <=1 && word2.length !=1) {
            for (String string : word2) {
                s2 = s2+string;
            }
            return word1[0].equals(s2);
        }

        if (word2.length <=1 && word1.length !=1) {
            for (String string : word1) {
                s1 = s1+string;
            }
            return word2[0].equals(s1);
        }
        for (String string : word1) {
            s1 = s1+string;
        }
        for (String string : word2) {
            s2 = s2+string;
        }
        
        return s1.equals(s2);
    }
}
