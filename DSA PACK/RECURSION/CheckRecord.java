public class CheckRecord {
    public static void main(String[] args) {
        String s = "LLLALL";
        AttendanceCheck(s);
    }
    static boolean AttendanceCheck(String s){
        
        int count_A=0;
        int count_L=0;
        int i=0;
        while (i<s.length()) {
            if (s.charAt(i)=='P') {
                count_L=0;
            }
            if (s.charAt(i)=='A') {
                count_A++;
                count_L=0;
            }
            if (s.charAt(i)=='L') {
                count_L++;
                if (count_L>=3) {
                    return false;
                }
            }
            i++;
        }

        System.out.println(count_A +" "+count_L+" ");

        if (count_A>2 || count_L>=3) {
           return false;
        }
        else{
            return true;
        }
         
    }
}
