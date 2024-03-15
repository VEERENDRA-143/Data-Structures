public class PlaceFlowers {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 0, 0, 1 };
        int n = 2;
        System.out.println(canPlaceFlowers(nums, n));
    }

    public static boolean canPlaceFlowers(int[] flower, int n) {
        for (int i = 0; i < flower.length; i++) {
            if (flower[i] == 0) {
                if ((i == 0 || flower[i - 1] != 1) && (i == flower.length - 1 || flower[i + 1] != 1)) {
                    flower[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
