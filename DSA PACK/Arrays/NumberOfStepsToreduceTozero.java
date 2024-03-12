public class NumberOfStepsToreduceTozero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(0));
    }
    public static int numberOfSteps(int num) {
        int count =0;
        if (num ==0) {
            return 0;
        }
        while (num != 0) {
            
            if (num%2 !=0) {
                num = num-1;
                num = num/2;
                // System.out.println(num);
                count ++;count++;
            }
            else{
                num = num/2;
                // System.out.println(num);
                count++;
            }
        }
        return count-1;
    }
}
