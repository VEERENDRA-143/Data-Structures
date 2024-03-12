// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

// You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

public class SumOfIntegerStrings {
    public static void main(String[] args) {

        System.out.println(addStrings("69", "71"));

    }
    public static String addStrings(String num1, String num2) {

            if (num1.length()==0) {
                return num2;
            }

            if (num2.length()==0) {
                return num1;
            }

            return String.valueOf(convertToInt(num1) + convertToInt(num2));
    }
    private static int convertToInt(String s) {
        int ans = 0;

        for (int i = s.length()-1; i >= 0; i--) {

            ans = (int) (ans+((int)s.charAt(i)-48)*(Math.pow(10.0, (s.length()-1)-i)));

        }

       return ans;
    }

}

//  =========== Approch - 2 ===============
// class Solution {
//     public String addStrings(String num1, String num2) {
//         StringBuilder str = new StringBuilder();

//         int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;

//         while (i >= 0 || j >= 0 || carry > 0) {
//             int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
//             int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

//             sum = digit1 + digit2 + carry;
//             str.append(sum % 10);
//             carry = sum / 10;
//         }

//         return str.reverse().toString();
//     }
// }
