import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        fizzBuzz(15);
    }
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            if ((i) %15==0) {
                list.add("FizzBuzz");
                System.out.print("FizzBuzz ");
            }
            else if ((i) %3==0) {
                list.add("Fizz");
                System.out.print("Fizz ");
            }
            else if ((i) %5==0) {
                list.add("Buzz");
                System.out.print("Buzz ");
            }

            else {
                list.add(String.valueOf(i));
                System.out.print(String.valueOf(i)+" ");
            }
            
            
        }
        return list;
    }
}
