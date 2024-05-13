public class NoOfPairsinterchangeble {
    public static void main(String[] args) {
        int[][] rectangles = {
                                {4,8},
                                {3,6},
                                {10,20},
                                {15,30}
                            };
        interchangeableRectangles(rectangles);
    }
    public static void interchangeableRectangles(int[][] rectangles) {

        long ans = 0;

        int[] arr = new int[rectangles.length];

        for (int i = 0; i < rectangles.length; i++) {
            
            for (int j = 0; j < rectangles[i].length; j++) {
                System.out.println(rectangles[i][j]);
            }
        }
    }
}
