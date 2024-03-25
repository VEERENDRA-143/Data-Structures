import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PascalsTriangle {
    public static void main(String[] args) {
        getRow(0);
    }
    public static void generate(int rows){
        List<List<Integer>> ans = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        for(int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < rows-i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++){
                // System.out.print(" "+ncr(i, j));
                list.add(ncr(i, j));
            }
            System.out.println();
            stack.push(list);
            ans.add(list);
         }
         
         for (List<Integer> list : ans) {
            for (Integer element : list) {
                System.out.print(element);
            }
            System.out.println();
         }

    }

    private static int fact(int num) {
        int factorial;
    
        for(factorial = 1; num > 1; num--){
            factorial *= num;
        }
        return factorial;
    }

    private static int ncr(int n,int r) {
        return fact(n) / ( fact(n-r) * fact(r) );
    }


    public static List<Integer> getRow(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> du = new ArrayList<>();
        if (numRows==0) {
            du.add(1);
            return du;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i <= numRows; i++) {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> new_row = new ArrayList<>();
            new_row.add(1);
            stack.push(new_row);

            for (int j = 1; j < prev_row.size(); j++) {
                new_row.add(prev_row.get(j - 1) + prev_row.get(j));
            }

            new_row.add(1);
            stack.push(new_row);
        }

        List<Integer> ans = stack.peek();

        for (Integer integer : ans) {
            System.out.print(integer);
        }
        
        return stack.pop();
    }
}
