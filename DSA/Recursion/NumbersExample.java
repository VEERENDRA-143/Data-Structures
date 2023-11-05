public class NumbersExample {

    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){
        System.out.println(1);
        print1(2);
    }

    static void print1(int n){
        System.out.println(2);
        print2(3);
    }

    static void print2(int n){
        System.out.println(3);
    }
}