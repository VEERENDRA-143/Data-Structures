

class Sum_Of_digits {
    static int sum = 0;
    static void reverse(int n) {
        
        if (n == 0) {
            return;
        }
        int rem = n*10;
        sum = sum*10 + rem;
        reverse(n/10);
    }
    public static void main(String[] args) {
        reverse(1234);
        System.out.println(sum);
    }

    static int sum_digit(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sum_digit(n / 10);
    }

    static int pro_digit(int n) {
        if (n % 10 == n) {
            return n;
        }
        return (n % 10) * pro_digit(n / 10);
    }

    

}