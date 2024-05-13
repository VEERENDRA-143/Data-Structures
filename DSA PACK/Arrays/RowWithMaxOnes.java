import java.util.Arrays;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] mat = {
            {0,0},
            {1,1},
            {0,0}
        };
        rowAndMaximumOnes(mat);
    }

    public static void rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];

        int ind=0;
        int max=0;
        for (int i=0;i<mat.length;i++) {
            int maxCount = findMaxones(mat[i]);
            if (maxCount>max) {
                max = maxCount;
                ind = i;
            }
        }
        ans[0] = ind;
        ans[1] = max;

        System.out.println(Arrays.toString(ans));
    }


    private static int findMaxones(int[] row) {
        int max =0;
        for (int i = 0; i < row.length; i++) {
            if (row[i]==1) {
                max++;
            }
        }
        return max;
    }
}
