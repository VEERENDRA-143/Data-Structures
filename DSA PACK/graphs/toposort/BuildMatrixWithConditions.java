import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BuildMatrixWithConditions {
    public static void main(String[] args) {
        int  k = 3;
        int[][] rowConditions = {
            {1,2},
            {2,3},
            {3,1},
            {2,3}
        };
        int[][] colConditions = {
            {2,1},
            // {3,2}
        };
        buildMatrix(k, rowConditions, colConditions);
    }
    public static void buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        ArrayList<ArrayList<Integer>> adjListRow =new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adjListRow.add(new ArrayList<>());
        }
        for (int[] is : rowConditions) {
            adjListRow.get(is[0]).add(is[1]);
        }

        int[] inDegreeRow = new int[k+1];
        for (int[] is : rowConditions) {
            inDegreeRow[is[1]]++;
        }


        ArrayList<ArrayList<Integer>> adjListCol =new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adjListCol.add(new ArrayList<>());
        }
        for (int[] is : colConditions) {
            adjListCol.get(is[0]).add(is[1]);
        }
        
        int[] inDegreeCol = new int[k+1];
        for (int[] is : colConditions) {
            inDegreeCol[is[1]]++;
        }
       
        ArrayList<Integer> rowsSort = topoSort(inDegreeRow,adjListRow);
        ArrayList<Integer> colsSort = topoSort(inDegreeCol,adjListCol);

        System.out.println(rowsSort);
        System.out.println(colsSort);

        int[][] ansMatrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rowsSort.get(i).equals(colsSort.get(j))) {
                    ansMatrix[i][j] = rowsSort.get(i);
                }
            }
        }
        
        for (int[] it : ansMatrix) {
            System.out.println(Arrays.toString(it));
        }
    }
    private static ArrayList<Integer> topoSort(int[] inDegree,ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] visited = new boolean[inDegree.length];

        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            
            for (int ele : adj.get(node)) {
                inDegree[ele]--;
                if (inDegree[ele] == 0) {
                    visited[ele] = true;
                    q.offer(ele);
                }
            }
            
        }
        return list;
    }
}
