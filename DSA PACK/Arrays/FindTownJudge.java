import java.util.Arrays;

public class FindTownJudge {
    public static void main(String[] args) {
        int[][] trust = {
            {1,3},
            {2,3},
        };
        int n = 3;
        System.out.println(findJudge(n, trust));
    }
    public static int findJudge(int n, int[][] trust) {
        int[]  inDegree = new int[n+1];
        int[] outdegree = new int[n+1];
        // Find the Indgree of each node
        for (int i = 0; i < trust.length; i++) {
            inDegree[trust[i][1]]++;
        }

        for (int i = 0; i < trust.length; i++) {
            outdegree[trust[i][0]]++;
        }

        for (int i = 1; i <= outdegree.length; i++) {
            if (inDegree[i] == 2 && outdegree[i] == 0) {
                return i;
            }
        }
        System.out.println(Arrays.toString(inDegree));
        System.out.println(Arrays.toString(outdegree));
        return -1;
    }
}
