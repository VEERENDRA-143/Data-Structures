import java.util.ArrayList;
import java.util.Arrays;

public class SpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] potions={8,5,8};
        long success =16;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : spells) {
            int count=0;
            for (int j : potions) {
                if (i*j>=success) {
                    count++;
                }
            }
            list.add(count);
            
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
