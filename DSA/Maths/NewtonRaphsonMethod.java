
// Newton raphson method is used to find the Square root of the number

// Formula is ====>>  root = squrt(x + (x/N)/2)

//  "X" is Assumed root
//  "N" is Actual Number to find the root


public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        System.out.println(NRM(40));
    }

    static double NRM(double n){
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n/x));

            if (Math.abs(root - x) < 0.5) {
                break;
            }

            x = root;
        }
        return root;
    }
}
