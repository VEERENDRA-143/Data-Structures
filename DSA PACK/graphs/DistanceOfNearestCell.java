// https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {

    int first;
    int second;
    int third;
    
    public Node(int first, int second, int third)    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    
}

public class DistanceOfNearestCell {

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,0},
            {1,1,0,0},
            {0,0,1,1}
        };
        int[][] ans = nearest(grid);
        for (int[] is : ans) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static int[][] nearest(int[][] grid){
        // Code here
        int n = grid.length; 
	    int m = grid[0].length; 
	    // visited and distance matrix
	    int vis[][] = new int[n][m]; 
	    int dist[][] = new int[n][m]; 
	    // <coordinates, steps>
	    Queue<Node> q = new LinkedList<Node>();
	    // traverse the matrix
	    for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	        // start BFS if cell contains 1
	            if(grid[i][j] == 1) {
	                q.add(new Node(i, j, 0)); 
	                vis[i][j] = 1; 
	            }
	            else {
	                // mark unvisted 
	                vis[i][j] = 0; 
	            }
	        }
	    }
	    
	    
	    
	    int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
	    
	    
	    // n x m x 4 
	    // traverse till queue becomes empty
	    while(!q.isEmpty()) {
	        int row = q.peek().first; 
	        int col = q.peek().second; 
	        int steps = q.peek().third; 
	        q.remove(); 
	        dist[row][col] = steps; 
	        // for all 4 neighbours
	        for(int i = 0;i<4;i++) {
	            int nrow = row + delrow[i]; 
	            int ncol = col + delcol[i]; 
	            // check for valid unvisited cell
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
	            && vis[nrow][ncol] == 0)  {
	                    vis[nrow][ncol] = 1; 
    	            q.add(new Node(nrow, ncol, steps+1));  
	            } 
	            }
	        }
	    
	    // return distance matrix
	    return dist; 
    }
}
