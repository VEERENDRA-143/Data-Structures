
import java.util.*;
public class PathWithMinEffort {
    public static void main(String[] args) {
        PathWithMinEffort ob = new PathWithMinEffort();
        int[][] heights = {
            {1,2,1,1,1},
            {1,2,1,2,1},
            {1,2,1,2,1},
            {1,2,1,2,1},
            {1,1,1,2,1}
        };
        System.out.println(ob.minimumEffortPath(heights));
    }
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];
        for (int[] is : distance) {
            Arrays.fill(is,(int)1e9);
        }
        distance[0][0]= 0;

        int[][] directions = { {-1,0},{+1,0},{0,-1},{0,+1}};

        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)-> x.dis - y.dis);
        q.add(new Pair(0, 0, 0));

    
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int diff = pair.dis;
            int row = pair.row;
            int col = pair.col;

            if (row == n-1 && col == m-1) {
                return diff;
            }
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0  && newCol >= 0 && newRow < n && newCol < m) {
                    int effort = Math.max(
                                    Math.abs(heights[newRow][newCol] - heights[row][col]),
                                    diff
                                );
                    if (effort < distance[newRow][newCol]) {
                        distance[newRow][newCol]= effort;
                        q.offer(new Pair(effort, newRow, newCol));
                    }
                }
            }
        }
        return -1;
    }
    public class  Pair {
    
        int dis,row,col;

        public Pair(int dis, int row, int col) {
            this.dis = dis;
            this.row = row;
            this.col = col;
        }

    }
}
