public class greter {
    public static void main(String[] args) {
        int[] arr={7,3,6,1,9,10};
        System.out.println(Gretest(arr));
    }

    static int Gretest(int[] arr){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}