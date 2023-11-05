public class FindMinMaxArray {
    public static void main(String[] args) {
        int[] arr={2,1,6,3,8,10};
        MinMax(arr);
    }

    static void MinMax(int[] arr) {
        int max = 0;
        int min = 1000;
        for (int i : arr) {
            if (i>max) {
                max=i;
            }
            if(i<min){
                min=i;
            }
        }

        System.out.println(min + " " + max);
    }
}
