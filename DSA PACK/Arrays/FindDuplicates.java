
public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr={1,2,1,1,2,3,5};
        System.out.println("Duplicated Elements are: ");
        Duplictes(arr);
    }
    static void Duplictes(int[] arr){
        int max = maxelement(arr);
        int[] count = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i]>1) {
                System.out.println(i);
            }
        }
    }

    static int maxelement(int[] arr){
        int max=0;
        for (int i : arr) {
            if (i>max) {
                max=i;
            }
        }
        return max;
    }
}
