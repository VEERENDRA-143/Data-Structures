import java.util.*;
public class Distinictislands {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };
        System.out.println(countDistinctIslands(grid));
    }
    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<String> ve =  new ArrayList<>();
                    dfs(i,j,visited,ve,i,j,grid);
                    set.add(ve);
                }
            }
        }

        return set.size();
    }
    private  static void dfs(int row, int col, boolean[][] visited, ArrayList<String> ve, int row0, int col0,int[][] grid) {
        visited[row][col] = true;
        ve.add(toString(row-row0,col-col0));
        int n= grid.length;
        int m =grid[0].length;

        int[] delRow = {+1,0,-1,0};
        int[] delCol = {0,-1,0,+1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >=0 && nCol >= 0 && nRow <= n-1 && nCol <= m-1 && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, visited, ve, row0, col0, grid);
            }

        }
    }

    private static String toString(int i, int j) {
        return i+""+j;
    }

}
