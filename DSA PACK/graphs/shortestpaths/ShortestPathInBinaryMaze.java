public class ShortestPathInBinaryMaze {
    public static void main(String[] args) {

        ShortestPathInBinaryMaze o =new ShortestPathInBinaryMaze();
        
        int[][] grid = {
            {0,0,0},
            {1,1,0},
            {1,1,0},
        };

        System.out.println(o.shortestPathBinaryMatrix(grid));

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        return f(0, 0, grid);
    }

    public int f(int row,int col,int[][] grid){

        if (grid[row][col] == 0) {
            return 1;
        }
        if (row == grid.length && col == grid[0].length) {
            return 0;
        }

        if (row >= grid.length && col >=grid[0].length || (row < 0 && col<0)) {
            return 0;
        }

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 1) {
            return 0;
        }

        int min= Integer.MAX_VALUE;

        int down = f(row+1, col, grid);
        int up  = f(row-1, col, grid);
        int left  = f(row, col+1, grid);
        int right  = f(row, col-1, grid);
        int rightDown = f(row+1, col+1, grid);
        int leftDown  = f(row+1, col-1, grid);
        int leftUp  = f(row-1, col-1, grid);
        int rightUp  = f(row-1, col+1, grid);
        int minim = Math.min(down, 
                    Math.min(up, 
                    Math.min(left, 
                    Math.min(right, 
                    Math.min(rightDown,
                    Math.min(leftDown, 
                    Math.min(leftUp, rightUp)))))));

        min += (1 + minim);
        return min;
    }
}
