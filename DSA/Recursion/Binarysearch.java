public class Binarysearch {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 7, 3, 8, 10, 22, 34, 64, 76 };
        int target = 64;
        System.out.println(BS(arr, target, 0, 10));
    }

    static int BS(int[] arr, int target, int satrt, int end) {
        if (satrt > end) {
            return -1;
        }
        int mid = satrt + (end - satrt) / 2;
        if (arr[mid] < target) {
            return BS(arr, target, mid + 1, end);
        }
        if (arr[mid] > target) {
            return BS(arr, target, satrt, mid - 1);
        } else {
            return mid;
        }
    }
}
