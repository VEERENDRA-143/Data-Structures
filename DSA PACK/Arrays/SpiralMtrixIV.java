import java.util.Arrays;

public class SpiralMtrixIV {
    public static void main(String[] args) {
        int m = 4, n = 5;
        int[] head = { 515,942,528,483,20,159,868,999,474,320,734,956,12,124,224,252,909,732};
        spiralMatrix(m, n, head);
    }

    public static void spiralMatrix(int m, int n, int[] head) {
        int[][] mat = new int[m][n];

        for (int[] is : mat) {
            Arrays.fill(is,-1);
        }
        int ind = 0;

        int top = 0;
        int right = n - 1;
        int bottom = m - 1;

        
        while (ind != head.length) {
            // left to right
            for (int i = 0; i < n; i++) {
                if (ind >= head.length) {
                    for (int[] is : mat) {
                        System.out.println(Arrays.toString(is));
                    }
                    return;
                }
                mat[top][i] = head[ind++];
                
            }
            top++;

            // top to bottom
            for (int i = top; i < m; i++) {
                if (ind >= head.length-1) {
                    for (int[] is : mat) {
                        System.out.println(Arrays.toString(is));
                    }
                    return;
                }
                mat[i][right] = head[ind++];
            }
            right--;

            // right to left
            for (int i = n - 2; i >= 0; i--) {
                if (ind >= head.length-1) {
                    for (int[] is : mat) {
                        System.out.println(Arrays.toString(is));
                    }
                    return;
                }
                mat[bottom][i] = head[ind++];
            }
            bottom--;
        }

        for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        }
    }
}
