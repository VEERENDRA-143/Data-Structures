import java.util.*;
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {
            {0,1,0},
            {0,0,0},
            {0,0,1},
        };
        System.out.println(shortestBridge(grid));
    }

    public static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    first =i;
                    second = j;
                    break;
                }
            }
        }
        List<int[]> q = new ArrayList<>();
        dfs(n, first, second, grid, q);

        int distance = 0;
        while (!q.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] pair : q) {
                int x = pair[0],y =pair[1];
                for (int[] nextPair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int cuX = nextPair[0],curY = nextPair[1];
                    if (cuX >= 0 && curY >= 0 && cuX < n && curY < n) {
                        if (grid[cuX][curY] == 1) {
                            return distance;
                        }
                        if (grid[cuX][curY] == 0) {
                            newBfs.add(nextPair);
                            grid[cuX][curY] = -1;
                        }
                    }
                }
            }
            q = newBfs;
            distance++;
        }
        return distance;

    }

    public static void dfs(int node,int row,int col,int[][] grid,List<int[]> q){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        
        grid[row][col] = 2;
        q.add(new int[]{row,col});

        dfs(node, row+1, col, grid,q);
        dfs(node, row-1, col, grid,q);
        dfs(node, row, col+1, grid,q);
        dfs(node, row, col-1, grid,q);

    }

}
