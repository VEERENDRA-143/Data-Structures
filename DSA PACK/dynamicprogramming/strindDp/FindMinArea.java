import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindMinArea {
    public static void main(String[] args) {
        int[][] grid ={
            {0,1,0},
            {1,0,1},
        };
        System.out.println(minimumArea(grid));
    }
    public static int minimumArea(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    
                    set.add(i);
                    set2.add(j);
                }
            }
        }
        Integer[] arr1 = set.toArray(new Integer[0]);
        Integer[] arr2 = set2.toArray(new Integer[0]);

        int min1 = arr1[0];
        int max1 = arr1[arr1.length-1];

        int min2 = arr2[0];
        int max2 = arr2[arr2.length-1];
        int area = (max1-min1+1)*(max2-min2+1);
        return area;
    }
}
