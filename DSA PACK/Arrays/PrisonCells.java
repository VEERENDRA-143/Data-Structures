import java.util.Arrays;

public class PrisonCells {
    public static void main(String[] args) {
        int[]  cells = {0,1,0,1,1,0,0,1};
        int n = 7;
        int[] ans = prisonAfterNDays(cells, n);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] ans = new int[cells.length];
        ans[0] = 0;
        ans[cells.length-1] = 0;
        for (int j = 0; j < n; j++) {

            for (int i = 1; i < cells.length-1; i++) {
                if (cells[i-1]==cells[i+1]) {
                    ans[i] = 1;
                }
                else{
                    ans[i]=0;
                }
            }
            
            System.out.println("Day "+ j + " : " + Arrays.toString(ans));
            cells = ans.clone();
        }

        return ans;
        
    }
}
