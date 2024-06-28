import java.util.Arrays;

public class MaxTotalImpRoads {
    public static void main(String[] args) {
        int[][] roads = {
            {0,3},
            // {1,2},
            // {2,3},
            // {0,2},
            {2,4},
            {1,3},
            
        };
        maximumImportance(5, roads);
    }
    public static long maximumImportance(int n, int[][] roads) {
        int[] deg = new int[n];
        for (int[] road : roads) {
            deg[road[0]]++;
            deg[road[1]]++;
        }
        Arrays.sort(deg);

        int sum = 0;
        int v =1;
        for (int de : deg) {
            sum += (de * v);
            v++;
        }
        return 0;
    }
}
