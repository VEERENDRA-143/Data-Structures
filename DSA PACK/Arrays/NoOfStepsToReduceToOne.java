
public class NoOfStepsToReduceToOne {

    public static void main(String[] args) {
        String s = "1111011110000011100000110001011011110010111001010111110001";
        numSteps(s);
    }   
    public static void numSteps(String s) {
        
        int num = binaryTodecimal(s);
        int steps = findSteps(num);
        System.out.println(steps);
    }

    private static int binaryTodecimal(String s) {
        int num = 0;
        int index = 0;
        for (int i = s.length()-1; i >=0; i--) {
            num += (s.charAt(i)-'0')*(int)(Math.pow(2, index++));
        }
        System.out.println(num);
        return num;
    }

    private static int findSteps(int num) {
        int steps = 0;
        while (num != 1) {
            if (num%2==0) {
                num /= 2;
            }
            else{
                num+=1;
            }
            steps++;
        }
        return steps;
    } 

    // Approch - 2
    public static int numSteps2(String s) {
        int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }

        }

        return res + carry;
    }
    
}