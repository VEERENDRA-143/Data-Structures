import java.util.Arrays;

public class FlipingImg {
    public static void main(String[] args) {
        int[][] image = {
            {1,1,0,0},
            {1,0,0,1},
            {0,1,1,1},
            {1,0,1,0}
        };
        flipAndInvertImage(image);
    }
    public static void  flipAndInvertImage(int[][] image) {
        // int[][] ans = new int[image.length][image[0].length];

        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
            int start=0;
            int end=row.length-1;
            while (start<=end) {

                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                if (start != end) {
                    row[start] = row[start]==0 ? 1 : 0;
                    row[end] = row[end]==0 ? 1 : 0;
                }
                else{
                    row[start] = row[start]==0 ? 1 : 0;
                }

                start++;
                end--;
            }
        }

        System.out.println();
        for (int[] r : image) {
            System.out.println(Arrays.toString(r));
        }

    }
}
