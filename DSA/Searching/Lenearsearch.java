import java.util.Scanner;

public class Lenearsearch {

    public static void main(String[] args) {
        int[] arr =  new int[]{12,34,98,45,14};
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter search Item = ");
            int n = input.nextInt();
            linar_search(arr,n);
        }
    }
    static void linar_search(int[] arr,int n){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==n){
                System.out.println("The position is at : " + (i+1));
                break;
            }

        }
    }
}