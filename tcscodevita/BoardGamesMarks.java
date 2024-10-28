// BoardGames
// Problem Description
// Ankitha enjoys finding new games. One day, she found a grid with dimensions M*N and decided to make up a special game to play on it. When Ankitha came up with the idea for the new game, her friend Akhil joined her. She then decided to share and explain the game to him.

// Akhil is given a grid with dimensions M*N, where each cell contains either 0 or 1. Additionally, he is provided with the coordinates of source and destination cells.You can only move to places whose value is 0. Furthermore, he is given the move rule (x, y) which helps in finding the location for the next move. From the given cell, you can move in four directions (forward, back,right ,left), unless they are out of grid. The rules for finding the next move from a current cell are given below.

// For moving forward, add the move rule to the current cell.
// For moving right, from current position add the move rule, rotate the path 90 degree clockwise,
// For moving left, from current position add the move rule, rotate the path 90 degree anticlockwise direction,
// For moving backward, from current position add the move rule, rotate the path 180 degree in clock or anti clockwise.

import java.util.Arrays;
import java.util.Scanner;

class BoardGamesMarks{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int M = scn.nextInt();
        int N = scn.nextInt();
        int[][] grid = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0}
        };

        int[] source = {0,0};
        int[] dest = {4,4};
        int[] rule = {0,2};

        find(grid, source, dest, rule);

    }

    public static void find(int[][] grid,int[] source,int[] dest,int[] rule){

        int row = source[0];
        int col = source[1];

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        int ans = f(grid, row, col, dest[0], dest[1], rule[0], rule[1],visited,dp);

        System.out.println(ans);

        for (boolean[] bs : visited) {
            System.out.println(Arrays.toString(bs));
        }


    }

    public static int f(int[][] grid,int row,int col, int dr, int dc,int rr,int rc,boolean[][] visited,int[][] dp){

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1 || visited[row][col]) {
            return 10000000;
        }
        
        if (row == dr && col == dc) {
            return 1;
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        visited[row][col] = true;
        int forward = 1 +  f(grid, row+rr, col+rc, dr, dc, rr, rc,visited,dp);
        int right =   1 +  f(grid, row+rc, col-rr, dr, dc, rr, rc,visited,dp);
        int left =    1 +  f(grid, row-rc, col+rr, dr, dc, rr, rc, visited,dp);
        int back =    1 +  f(grid, row-rr, col-rc, dr, dc, rr, rc,visited,dp);

        return dp[row][col] = Math.min(Math.min(forward, back),Math.min(left, right));
    }
}