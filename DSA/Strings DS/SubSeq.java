import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        SubSets("abc", "");
        System.out.println("Array lists ");
        System.out.println(SubSeqSet("abc", ""));
    }

    static void SubSets(String actul_String,String ans){
        if (actul_String.isEmpty()) {
            System.out.println(ans);
            return;
        }

        char ch = actul_String.charAt(0);
        SubSets(actul_String.substring(1), ch+ans);
        SubSets(actul_String.substring(1), ans);
    }

    static ArrayList<String> SubSeqSet(String actual_String,String ans){

        if (actual_String.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = actual_String.charAt(0);

        ArrayList<String> left = SubSeqSet(actual_String.substring(1), ch+ans);
        ArrayList<String> right = SubSeqSet(actual_String.substring(1), ans);
        left.addAll(right);
        return left;
    }
}
