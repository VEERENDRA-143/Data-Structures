public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1,2,4,6,8,9,10,20 };
        int ans = Binary_Search(arr, 8);
        System.out.println("index = " + ans);
    }

    public static int Binary_Search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high ) / 2;
        while (low <= high) {
            if (target == arr[mid]) {
                return mid;
               
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }
}
