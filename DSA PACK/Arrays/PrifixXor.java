import java.util.Arrays;

public class PrifixXor {
    public static void main(String[] args) {
        int[] pref = {13};
        findArray(pref);
    }
    public static void findArray(int[] pref) {
        int[] ans = new int[pref.length];
        int XOR =0;
        ans[0] = pref[0]^XOR;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = pref[i-1]^pref[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
