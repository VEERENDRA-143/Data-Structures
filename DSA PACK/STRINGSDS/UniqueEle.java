public class UniqueEle {
    public static void main(String[] args) {
       Uniqueelementsinstring("","Hello");
    }
    static void Uniqueelementsinstring(String p,String up){
        
        for (int i = 0; i < up.length(); i++) {
           System.out.println(count(p,up,up.charAt(i)));
           
        }
    }
    private static String count(String p, String up, char charAt) {
        String s = "";
        for (int i = 0; i <= p.length(); i++) {
            if (p.charAt(i)!=charAt) {
                s+=charAt;
            }
        }
        return s;
    }

}
