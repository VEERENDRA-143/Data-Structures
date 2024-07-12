import java.util.*;
public class ShortestPathInbinaryMazeGFg {
    public static void main(String[] args) {
        ShortestPathInbinaryMazeGFg ob = new ShortestPathInbinaryMazeGFg();
        int grid[][] = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}
        };
        int[] source = {0, 1};
        int[] destination = {2, 2};
        System.out.println(ob.shortestPath(grid, source, destination));
    }

    public  int shortestPath(int[][] grid, int[] source, int[] destination) {


        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{-1,0},{+1,0},{0,-1},{0,+1}};

        int[][] distance = new int[n][m];

        for (int[] is : distance) {
            Arrays.fill(is,(int)1e9);
        }
        distance[source[0]][source[1]] = 0;
        
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, source[0], source[1]));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int dis = pair.dis;
            int row = pair.row;
            int col = pair.col;

            for (int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && dis+1 < distance[newRow][newCol]) {
                    distance[newRow][newCol] = 1 + dis;
                    if (newRow == destination[0] && newCol ==destination[1]) {
                        return dis+1;
                    }
                    q.add(new Pair(distance[newRow][newCol], newRow, newCol));
                }
            }
        }

        return -1;

    }

    class  Pair{
        
        int dis, row,col;
        Pair(int dis,int row,int col){
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
        
    }

}
