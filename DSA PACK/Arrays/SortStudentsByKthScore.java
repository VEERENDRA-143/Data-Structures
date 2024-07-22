import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SortStudentsByKthScore {
    public static void main(String[] args) {
        SortStudentsByKthScore o = new SortStudentsByKthScore();
        int[][] score = {
            {3,4},
            {5,6},
        };
        int k= 0;
        o.sortTheStudents(score, k);
    }
    public  int[][] sortTheStudents(int[][] score, int k) {
        int n = score.length;
        int m = score[0].length;
        int[][] ans =new int[n][m];

        int[] colEles = new int[n];
        ArrayList<Pair> data = new ArrayList<>();
        for (int i = 0; i < colEles.length; i++) {
            colEles[i] = score[i][k];
            data.add(new Pair(score[i][k], i));
        }
       
        Arrays.sort(colEles);
        int ansRow= 0;
        for (int i =  colEles.length-1; i >= 0; i--) {
            int eleRow = find(colEles[i],data);

            for (int j = 0; j < m; j++) {
                ans[ansRow][j] = score[eleRow][j];
            }
            ansRow++;
        }

        for (int[] it : ans) {
            System.out.println(Arrays.toString(it));
        }
        return  ans;
    }
    
   
    private int find(int target, ArrayList<Pair> data) {
        for (Pair pair : data) {
            if (pair.ele == target) {
                return pair.row;
            }
        }
        return -1;
    }


    public class Pair {
        
        int ele;
        int row;
        Pair(int ele,int row){
            this.ele = ele;
            this.row = row;
        }
        
    }

}
