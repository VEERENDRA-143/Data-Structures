public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] mat = {
            {1,2},
            {3,4}
        };
        int r = 2;
        int c = 4;
        matrixReshape(mat, r, c);
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r*c) {
            return mat;
        }
        int[] refer = new int[r*c];
        int index = 0;

        int[][] ans = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]+" ");
                refer[index++] = mat[i][j];
            }
            System.out.println();
        }

        index=0;

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = refer[index++];
            }
        }

        System.out.println();

        for (int[] is : ans) {
            for (int ele : is) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }

        return ans;
        
    }
}
