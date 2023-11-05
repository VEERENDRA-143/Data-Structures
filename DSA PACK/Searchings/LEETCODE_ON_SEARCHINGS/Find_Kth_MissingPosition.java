

public class Find_Kth_MissingPosition {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        System.out.println(findKthPositive(arr, 2));
    }

    public static int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;

    }
}
