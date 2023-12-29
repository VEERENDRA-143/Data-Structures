public class MotzinNumber {
    // Java Program to find Nth Motzkin Number.
	// Return the nth Motzkin Number.
	public static int motzkin(int n)
	{
		// Base Case
		if (n == 0 || n == 1){
            return 1;
        }

		// Recursive step
		return ((2 * n + 1) * motzkin(n - 1) +
				(3 * n - 3) * motzkin(n - 2)) / (n + 2);
	} 
	
	// driver code 
	public static void main(String[] args)
	{
		int n = 4;
		System.out.print( motzkin(n) );
	}
}


