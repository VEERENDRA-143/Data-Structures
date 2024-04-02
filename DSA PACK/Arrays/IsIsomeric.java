public class IsIsomeric {

    public static void main(String[] args) {
        String s="foo";
        String t="bar";
        checkIsomeric(s, t);
    }
    public static boolean checkIsomeric(String s,String t){
        int[] indexsOfS = new int[200];
        int[] indexsOfT = new int[200];

        if (s.length() != t.length()) {
            System.out.println("false");
            return false;
        }
        for(int i=0;i<s.length();i++) {
            if (indexsOfS[s.charAt(i)] != indexsOfT[t.charAt(i)]) {
                System.out.println("false");
                return false;
            }
            indexsOfS[s.charAt(i)] = i+1;
            indexsOfT[t.charAt(i)] = i+1;
        }
        System.out.println("true");
        return true;
    }
    
}