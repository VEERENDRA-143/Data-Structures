import java.util.ArrayList;
import java.util.List;

public class MaxCellsInDistenceOrder {
    public static void main(String[] args) {
        allCellsDistOrder(2,2, 0, 1);
    }
    public static void allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < cols; j++) {
                ArrayList<Integer> in = new ArrayList<>();
                // System.out.println(i +" "+j);
                int dis = Math.abs(i-rCenter)+Math.abs(j-cCenter);
                in.add(i);
                in.add(j);
                in.add(dis);
                // System.out.println(dis);
                list.add(in);
            }
            
        }
        for (List<Integer> list2 : list) {
            System.out.println(list2.get(2));
            
        }
        
    }
}
