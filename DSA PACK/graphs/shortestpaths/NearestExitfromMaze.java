import java.util.LinkedList;
import java.util.Queue;

public class NearestExitfromMaze {
    public static void main(String[] args) {
        char[][] maze = {
            {'+','+','+'},
            {'.','.','.'},
            {'+','+','+'},
        };
        int[] entrance = {1,0};
        System.out.println(nearestExit(maze, entrance));

    }
    public static int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze, entrance);
    }
    public static int bfs(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                if ((row != entrance[0] || col != entrance[1]) && (row == 0 || row == m - 1 || col == 0 || col == n - 1)) {
                    return steps;
                }
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                        maze[newRow][newCol] = '+';
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            
            steps++;
        }
        
        return -1; // No exit found
    }

}
