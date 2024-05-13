public class MinimumNoOfPrimes {
    public static void main(String[] args) {
        int number = 10;
        int count = 0;
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println("The minimum number of primes required to get " + number + " is " + count);


    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
