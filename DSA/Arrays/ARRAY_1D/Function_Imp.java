
import java.util.Scanner;

public class Function_Imp {
    // summ two numbers

    public static void main(String[] args) {
        sum();
    }
    static void sum(){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("enter A = ");  
            int a = input.nextInt();
            System.out.println("enter B = ");  
            int b = input.nextInt();
            int add= a+b;
            System.out.println(add);
        }
    }
}
