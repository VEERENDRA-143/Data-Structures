public class SpeacialPositionsInBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 0, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 }
        };
        numSpecial(mat);
    }

    public static void numSpecial(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // System.out.print(mat[i][j]+" ");
                if (mat[i][j] == 1) {
                    // System.out.println(i + " " + j);
                    getRowCol(mat, i, j);
                }
            }
            System.out.println();
        }
    }

    private static void getRowCol(int[][] mat, int row, int col) {
        System.out.println();
        for (int i = 0; i < mat[0].length; i++) {
            if (i != row  && mat[row][i] ==1) {
                System.out.print("false"+" ");
            }
            System.out.print(mat[row][i]+" ");
        }
        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            if (i != col && mat[i][col] == 1 ) {
                System.out.print("false"+" ");
            }
            System.out.print(mat[i][col]+" ");
        }
        System.out.println();
    }
}
