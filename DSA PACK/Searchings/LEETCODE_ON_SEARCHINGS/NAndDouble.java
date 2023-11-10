// Given an array arr of integers, check if there exist two indices i and j such that :

// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]

public class NAndDouble {
    public static void main(String[] args) {
        int[] arr = { -2, 0, 10, -19, 4, 6, -8 };
        System.out.println(checkIfExist(arr));
    }

    static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean doubleele = FindDouble(arr, arr[i], i);
            if (doubleele) {
                return true;
            }
        }
        return false;
    }

    private static boolean FindDouble(int[] arr, int ele, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (index != i) {
                if (2 * arr[i] == ele) {
                    return true;
                }
            }
        }
        return false;
    }
}
