import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        Permutations_String("", "123");

        // System.out.println(PermutationsCount("", "abcd"));
    }

    static void Permutations_String(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            Permutations_String(f + ch + s, up.substring(1));
        }
    }


    // Using Array List to Print all Possibilites
    static ArrayList<String> Permutations_StringList(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(Permutations_StringList(f + ch + s, up.substring(1)));
        }

        return ans;
    }


// Counting the No. Of Permutations
    static int PermutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        char ch = up.charAt(0);
        int count = 0;

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count += PermutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
