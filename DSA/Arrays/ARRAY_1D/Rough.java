import java.util.Scanner;


public class Rough{
    public static void main(String[] args) {
        System.out.println("Hello World!");

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter A : ");
            int x =input.nextInt();
            System.out.print("Enter B : ");
            int y =input.nextInt();
            int sum=x+y;
            System.out.println("sum is : "+sum);
        }
    }
}