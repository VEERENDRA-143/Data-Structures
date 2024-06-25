public class MinMovesToConvertStr {
    public static void main(String[] args) {
        String s= "OOOO";
        System.out.println(minimumMoves(s));
    }
    public static int minimumMoves(String s) {
        int c = 0;
        int i = 0;
        char[] sC = s.toCharArray();
        while (i < sC.length) {
            if (sC[i] == 'X') {
                // int temp = i;
                // int windowSize = temp+3;
                // while (temp < windowSize) {
                //     sC[i]= 'O';
                //     temp++;
                // }
                i += 3;
                c++;
            }
            else{
                i++;
            }
        }
        return c;
    }
}
