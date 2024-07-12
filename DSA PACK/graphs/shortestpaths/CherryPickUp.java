public class CherryPickUp {
    int sum = 0;
    public static void main(String[] args) {
        CherryPickUp ob=  new CherryPickUp();
        int[][] grid = {
            {1,1,-1},
            {1,-1,1},
            {-1,1,1}
        };
        System.out.println(ob.cherryPickup(grid));
    }
    public  int cherryPickup(int[][] grid) {
        
        f(0, 0, grid);
        return sum;
    }
    public void f(int row,int col,int[][] grid){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == -1) {
            return;
        }
        if (grid[row][col] == 1) {
            sum = sum + 1;
            grid[row][col] = 0;
        }
        f(row, col+1, grid);
        f(row+1, col, grid);

    }
}
