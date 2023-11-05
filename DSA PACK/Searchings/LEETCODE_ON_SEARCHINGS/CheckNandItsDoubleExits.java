public class CheckNandItsDoubleExits {
    public static void main(String[] args) {
        int[] arr = { 10,2,5,3};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        for (int i : arr) { 
            for (int j : arr) {
                if (i == 2 * j) {
                    if (i == 0) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}