import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i]>0) {
                stack.push(asteroids[i]);
            }
            else{
                while (!stack.isEmpty() && stack.peek() > 0 && 
                            Math.abs(asteroids[i]) < stack.peek()) {
                    stack.pop();
                }
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() + asteroids[i] == 0) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return new int[]{};
        }
        
        int[] ans = new int[stack.size()];
        for (int i = ans.length-1; i >=0 ; i--) {
            if (!stack.isEmpty()) {
                ans[i] = stack.pop();
            }
            else{
                break;
            }
        }

        return ans;
    }
}

// ============== Approch -2 ====================

// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> stack = new Stack<>();
        
//         for (int a : asteroids) {
//             if (a > 0) {
//                 stack.push(a);
//             } else {
//                 while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
//                     stack.pop();
//                 }

//                 if (stack.isEmpty() || stack.peek() < 0)  {
//                     stack.push(a);
//                 }

//                 if (stack.peek() == -a) {
//                     stack.pop();
//                 }
//             }
//         }

//         int[] res = new int[stack.size()];
//         int i = stack.size() - 1;

//         while(!stack.isEmpty()) {
//             res[i--] = stack.pop();
//         }

//         return res;   
//     }
// }
