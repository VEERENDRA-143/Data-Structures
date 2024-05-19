public class CheckGridStisfiesCondition {
    public static void main(String[] args) {
        int[][] grid = {
            {1,7},
            {1,1},
        };
        satisfiesConditions(grid);
    }
    public static void satisfiesConditions(int[][] grid) {
        boolean result = false;
        if (grid.length==1 && grid[0].length==1) {
            System.out.println("true");
            return;
        }
        for (int i = 0; i < grid.length-1; i++) {
            for (int j = 0; j < grid[i].length-1; j++) {
                System.out.print(grid[i][j]+" ");
                if (grid[i][j] == grid[i + 1][j] && grid[i][j] != grid[i][j + 1]) {
                    result = true;
                }
                else{
                    System.out.println("false");
                    return;
                }
            }
            System.out.println();
        }
        System.out.println(result);
    }
}
