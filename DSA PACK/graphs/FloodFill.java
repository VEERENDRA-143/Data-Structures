public class FloodFill {
    public static void main(String[] args) {
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {


        if (sr < 0 || sr > image.length || sc < 0 || sc >= image[0].length ) {
            return image;
        }

        image[sr][sc] = color;

        floodFill(image, sr+1, sc, color);
        floodFill(image, sr-1, sc, color);
        floodFill(image, sr, sc+1, color);
        floodFill(image, sr, sc-1, color);
        return image;
    }
}
