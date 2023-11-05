import java.util.ArrayList;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        System.out.println(searchRange(arr, 8));
    }

    public static ArrayList<Integer> searchRange(int[] nums, int target) {

        ArrayList<Integer> ans = new ArrayList<>();

        int start = 0;
        int end = 0;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (nums[mid] == target) {
                ans.add(mid);
                break;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
        }

        return ans;

    }
}
