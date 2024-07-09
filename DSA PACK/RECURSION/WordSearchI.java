public class WordSearchI {
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        String word = "ABCCED";

        System.out.println(exist(board, word));

    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n+1][m+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean check = f(0, i, j, board, word, visited);
                    if (check) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean f(int ind,int row,int col,char[][] board, String word,boolean[][] visited){

        if (ind == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length ||col >= board[0].length  || visited[row][col] || board[row][col] != word.charAt(ind)) {
            return false;
        }
        visited[row][col] = true;

        boolean down = f(ind+1, row + 1, col, board, word, visited);
        boolean up = f(ind+1, row - 1, col, board, word, visited);
        boolean left = f(ind+1, row, col + 1, board, word, visited);
        boolean right = f(ind+1, row, col - 1, board, word, visited);

        if (down || up || left || right) {
            return true;
        }

        visited[row][col] = false;
        return false;

    }
}
