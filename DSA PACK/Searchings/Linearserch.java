public class Linearserch {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 1, 8, 9 };
        int ans = Linear_serch(arr, 18);
        System.out.println("index = " + ans);
    }

    public static int Linear_serch(int[] arr, int tareget) {
        for (int i = 0; i < arr.length; i++) {
            if (tareget == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}