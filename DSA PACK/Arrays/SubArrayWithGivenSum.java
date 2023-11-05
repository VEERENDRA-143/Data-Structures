public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 0, 0, 5, 6 };
        int k = 11;
        subarry(arr, k);
    }

    static void subarry(int[] arr, int k) {
        System.out.println("-----------------------------------");
        System.out.println("start index" + "|" + " end index " + " | " + " Ans");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                arr[i] += arr[j];
                if (arr[i] == k) {
                    System.out.println("-----------------------------------");
                    System.out.println("      " + i + "    |  " + "     " + j + "    |  " + arr[i]);
                }
            }
        }
        System.out.println("-----------------------------------");
    }
}
