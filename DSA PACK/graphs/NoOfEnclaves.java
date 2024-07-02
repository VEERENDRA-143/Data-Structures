import java.util.*;
public class NoOfEnclaves {

    class Pair {
        
        int first;
        int sceond;

        public Pair(int first, int sceond) {
            this.first = first;
            this.sceond = sceond;
        }
        
    }

    public int numEnclaves(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<Pair>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0||j == 0|| i == n-1 || j == m-1) {
                    if (grid[i][j]==1) {
                        q.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().sceond;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nCol >=0 && nRow < n && nCol < m && visited[nRow][nCol] && grid[nRow][nCol] ==1) {
                    visited[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    c++;
                }
            }
        }
        return c;

    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0},
        };
        NoOfEnclaves on = new NoOfEnclaves();
        System.out.println(on.numEnclaves(grid));
    }

}
