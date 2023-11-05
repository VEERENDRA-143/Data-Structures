import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        System.out.println(PadRet("", "12"));
        System.out.println(PadCount("", "12"));
    }

    static void Pad(String p, String up) {

        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a'+i);
            Pad(p+ch, up.substring(1));
        }
    }

    // Using Array List
    static ArrayList<String> PadRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';

        ArrayList<String> li = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a'+i);
            li.addAll(PadRet(p+ch, up.substring(1)));
        }
        return li;
    }

    // Counting the No. Of Permutations
    static int PadCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a'+i);
            count += PadCount(p+ch, up.substring(1));
        }
        return count;
    }

}
