
public class NearestExitFromMazeDFS {
    public static void main(String[] args) {
        char[][] maze = {
            {'+','+','.','+'},
            {'.','.','.','+'},
            {'+','+','+','.'},
        };
        int[] entrance = {1,2};
        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        return f(entrance[0], entrance[1], maze, entrance, n, m, visited,dp);
    }

    public static int f(int row,int col ,char[][] maze,int[] entrance,int n,int m,boolean[][] visited,int[][] dp){

        if (row < 0 || col <0 || row > n-1 || col > m-1 || visited[row][col] || maze[row][col] == '+') {
            return 100001;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if ( (row != entrance[0] || col != entrance[1]) && (row == 0 || col == 0 || row == n-1 || col == m-1) ) {
            return 0;
        }

        visited[row][col] = true;
        int down =    f(row+1, col, maze, entrance, n, m,visited,dp);
        int up =  f(row-1, col, maze, entrance, n, m,visited,dp);
        int right =  f(row, col+1, maze, entrance, n, m,visited,dp);
        int left = f(row, col-1, maze, entrance, n, m,visited,dp);
        visited[row][col] = false;
        return dp[row][col] = Math.min(Math.min(left, right), Math.min(up, down)) + 1;
    }
    
}