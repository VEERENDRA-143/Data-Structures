import java.util.ArrayList;
import java.util.Deque;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class FindFirstPlayerToWinkGames {
    public static void main(String[] args) {
        int[] skills = {4,2,6,3,9};
        int k= 2;
        findWinningPlayer(skills, k);
    }
    public static void findWinningPlayer(int[] skills, int k) {
        
    //    int n = f(skills, k);
    //     for (int i = 0; i < skills.length; i++) {
    //         if (n == skills[i]) {
    //             return;
    //         }
    //     }
        int ans = findWinningPlayer2(skills, k);
        System.out.println(ans);
        
    }

    // TLE 
    public static int f(int[] skills, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();;
        for (int i = 0; i < skills.length; i++) {
            list.add(skills[i]);
            map.put(skills[i], 0);
        }

        while (map.get(list.get(0)) != k) {
            if (list.get(0) > list.get(1)) {
                list.add(list.remove(1));
            }
            else{
                list.add(list.remove(0));
            }
            
            map.put(list.get(0), map.get(list.get(0))+1);
            
            if (map.get(list.get(0)) == k) {
                System.out.println(list.get(0));
                return list.get(0);
            }
        }
        return -1;
    }

    public static int findWinningPlayer2(int[] skills, int k) {
        int maxIdx = -1;
        
        int max = 0;
        
        for (int i = 0; i < skills.length; ++i) {
            if (skills[i] > max) {
                max = skills[i];
                maxIdx = i;
            }
        }
        
        int current = 0;
        int won = 0;
        
        for (int i = 1; i < skills.length; ++i) {
            if (skills[current] > skills[i])
                ++won;
            else{
                current = i;
                won = 1;
            }
            
            if (won == k)
                return current;
        }
        
        return maxIdx;
    }

}
