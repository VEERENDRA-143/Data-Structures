public class FillingBooks {
    public static void main(String[] args) {
        int[][] books = {
            {1,2},
            {2,3},
            {2,3},
            {1,1},
            {1,1},
            {1,1},
            {1,2}
        };
        int shelfWidth =4;
        System.out.println(minHeightShelves(books, shelfWidth));
    }
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        return f(0,books,shelfWidth);
    }
    private static int f(int ind, int[][] books, int shelfWidth) {

        if (ind >= books.length) {
            return 0;
        }
        int height = 0;
        int width = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = ind; i < books.length; i++) {
            width += books[i][0];
            if (width > shelfWidth) {
                break;
            }
            height = Math.max(height, books[i][1]);
            ans = Math.min(ans, height + f(ind+1, books, shelfWidth));
        }
        return ans;
    }
}
