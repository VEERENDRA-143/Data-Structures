import java.util.*;
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'O', 'O', 'X'}, 
            {'X', 'O', 'X', 'X'}, 
            {'X', 'X', 'O', 'O'}
        };

        solve(board);
    }
    public static void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
       

        // Top
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && !visited[0][i]) {
                dfs(0, i, board, visited);
            }
        }


        // Left
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, board, visited);
            }
        }

        // Bootom
        for (int i = 0; i < m; i++) {
            if (board[n-1][i] == 'O' && !visited[n-1][i]) {
                dfs(n-1, i, board, visited);
            }
        }

        // Right
        for (int i = 0; i < n; i++) {
            if (board[i][m-1] == 'O' && !visited[i][m-1]) {
                dfs(i, m-1, board, visited);
            }
        }

        for (boolean[] bs : visited) {
            System.out.println(Arrays.toString(bs));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println();
        for (char[] ar : board) {
            System.out.println(Arrays.toString(ar));
        }
    }
    public static void dfs(int row,int col,char[][] board,boolean[][] visited){

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row+1, col, board, visited);
        dfs(row-1, col, board, visited);
        dfs(row, col+1, board, visited);
        dfs(row, col-1, board, visited);

    }
}
