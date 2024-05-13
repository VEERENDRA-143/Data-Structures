public class ImageSmoother {
    public static void main(String[] args) {
        int[][] img = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        imageSmoother(img);
    }

    public static void imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int diff = findAdjCells(i, j, img);
                ans[i][j] = diff;

            }
        }
    }

    private static int findAdjCells(int x, int y, int[][] img) {
        int m = img.length; 
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                sum += img[nx][ny];
                count++;
            }
        }
        // System.out.println(cellsCount);
        return sum/count;
    }
}
