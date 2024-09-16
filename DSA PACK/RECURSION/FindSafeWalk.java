import java.util.*;

public class FindSafeWalk {

    public static void main(String[] args) {
        FindSafeWalk o =new FindSafeWalk();
        int[][] grid = {
            {0,1,1,0,0,0},
            {1,0,1,0,0,0},
            {0,1,1,1,0,1},
            {0,0,1,0,1,0}
        };
        int health =  3;

        boolean ans = o.findSafeWalk(grid, health);
        System.out.println(ans);

    }
    
    public boolean findSafeWalk(int[][] grid, int health) {
        
        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int[] is : visited) {
            Arrays.fill(is, -1);
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0,0,health));
        visited[0][0] = health;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            int curRow = p.row;
            int curCol = p.col;
            int curHealth = p.health;

            if (curRow == m-1 && curCol == n-1 && curHealth >= 1) {
                return true;
            }

            for(int[] dir : direction){
                int newRow = dir[0]+curRow;
                int newCol = dir[1]+curCol;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {

                    int newHealth = curHealth - grid[newRow][newCol];

                    if (newHealth > 0 && newHealth > visited[newRow][newCol] ) {
                        visited[newRow][newCol] = newHealth;
                        q.add(new Pair(newRow, newCol, newHealth));
                    }
                    
                }
            }

            
        }


        return false;
    }

    
    public class Pair {
        int row;
        int col;
        int health;

        public Pair(int row, int col, int health) {
            this.row = row;
            this.col = col;
            this.health = health;
        }

        
        
    }

}
