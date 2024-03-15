public class ReverseWordsInStrings {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(s.length());
        reverseWords(s,"");
    }       

    public static void  reverseWords(String s,String t) {
        String ans="";
        if (s.length()==0) {
            System.out.println(t.substring(0,t.length()-1));
            System.out.println(t.length());
            return;
        }
        int i = s.length()-1;

        while (s.charAt(i) != ' ') {
            if(i==0){
                break;
            }
            else{
                i--;
            }
        }
       
        if(i==0){
            ans += s.substring(i, s.length());
        }
        else{
            ans += s.substring(i+1, s.length());
        }
        reverseWords(s.substring(0, i),t+ans+" ");
        
        // System.out.println(t);
       
    }   
}
