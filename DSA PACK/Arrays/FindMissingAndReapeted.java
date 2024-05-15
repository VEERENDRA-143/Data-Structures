import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindMissingAndReapeted {
    public static void main(String[] args) {
        int[][] grid = {
            {9,1,7},
            {8,9,2},
            {3,4,6},
        };
        findMissingAndRepeatedValues(grid);
    }
    public static void findMissingAndRepeatedValues(int[][] grid) {
        ArrayList<Integer> list = new ArrayList<>();
        int repeatedNum = -1;
        int missinNum = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (list.contains(grid[i][j])) {
                    repeatedNum = grid[i][j];
                }
                else{
                    list.add(grid[i][j]);
                }
            }
        }
        Collections.sort(list);
        int end = list.get(list.size()-1);
        // System.out.println(end);
        int flag = 0;
        for (int i = 1; i <= end ; i++) {
            if (i != list.get(i-1)) {
                flag = 1;
                missinNum = i;
                break;
                // return;
                // System.out.println(i);
            }
        }
        if (flag == 0) {
            missinNum = list.size()+1;
        }

        int[] ans = new int[2];
        ans[0] = repeatedNum;
        ans[1] = missinNum;
        System.out.println(Arrays.toString(ans));
    }
}
