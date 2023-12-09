
public class DistanceValue {
    public static void main(String[] args) {
        int[] arr1 = {2,1,100,3};
        int[] arr2 = {-5,-2,10,-3,7};
        int d = 2;
        int ans = findTheDistanceValue(arr1,arr2,d);
        System.out.println(ans);
    }

    // Approch -1
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int sol = Math.abs(arr1[i]-arr2[j]);
                if (sol<=d && sol>0) {
                    count++;
                }
            }
        }
        return count;
    }

}

// Approch - 2
// public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    // int count=0;
    // for (int i = 0; i < arr1.length; i++) {
    //     for (int j = 0; j < arr2.length; j++) {
    //         if (Math.abs(arr1[i]-arr2[j])<=d) {
    //             count++;
    //             break;
    //         }
    //     }
    // }
    // return (arr1.length-count);
// }