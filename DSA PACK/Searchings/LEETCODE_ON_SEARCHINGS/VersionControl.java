public class VersionControl {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    static boolean isBadVersion(int version) {
        if (version == 4) {
            return false;
        } else {
            return true;
        }

    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        if (n == 1) {
            return 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            boolean resultMid = isBadVersion(mid);
            if (resultMid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

}
