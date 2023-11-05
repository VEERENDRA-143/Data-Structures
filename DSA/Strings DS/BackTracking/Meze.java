import java.util.ArrayList;

public class Meze {
    public static void main(String[] args) {
        // System.out.println(count(3, 3));
        // System.out.println(pathDiagnalList("", 3, 3));
        boolean[][] board = {
                { true, true, true },
                { true, false, true },
                { true, true, true }
        };
        pathRestrictions("", board, 0, 0);
    }

    static int count(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int left = count(row - 1, col);
        int right = count(row, col - 1);

        return left + right;
    }

    // Possible paths without diagonals
    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            path(p + 'D', r - 1, c);
        }

        if (c > 1) {
            path(p + 'R', r, c - 1);
        }
    }

    // Possible paths with diagonals
    static void pathDiagnal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1 && c > 1) {
            pathDiagnal(p + 'D', r - 1, c - 1);
        }
        if (r > 1) {
            pathDiagnal(p + 'V', r - 1, c);
        }

        if (c > 1) {
            pathDiagnal(p + 'H', r, c - 1);
        }
    }

    // Possible paths witht diagonals in Array List form
    static ArrayList<String> pathDiagnalList(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> li = new ArrayList<>();
        if (r > 1 && c > 1) {
            li.addAll(pathDiagnalList(p + 'D', r - 1, c - 1));
        }
        if (r > 1) {
            li.addAll(pathDiagnalList(p + 'V', r - 1, c));
        }

        if (c > 1) {
            li.addAll(pathDiagnalList(p + 'H', r, c - 1));
        }

        return li;
    }


    // If the (2,2) cell is with river
    static void pathRestrictions(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[row][col]) {
            return;
        }


        if (row < maze.length - 1) {
            pathRestrictions(p + 'D', maze, row + 1, col);
        }

        if (col < maze[0].length - 1) {
            pathRestrictions(p + 'R', maze, row, col + 1);
        }

    }


    
}