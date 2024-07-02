public class MaxpathSum {
    public static void main(String[] args) {
        int[][] A = {
            {5,2,4},
            {1,3,5},
            {9,2,7},
        };
        int n = A.length;
        int m = A[0].length;
        System.out.println(f(n-1, m-1, A));
    }
    public static int f(int i,int j,int[][] A){

        if (i == 0 && j == 0) {
            return A[0][0];
        }

        if ( i < 0 || j < 0) {
            return 0;
        }

        int up = f(i-1, j, A);
        int left = f(i, j-1, A);

        return A[i][j] + Math.max(up, left);
    }
}
