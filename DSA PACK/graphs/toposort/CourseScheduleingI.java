import java.util.*;
public class CourseScheduleingI {
    public static void main(String[] args) {
        int[][] prerequisites = {
            {1,0},
            {2,0},
            {3,1},
            {3,2},
        };
        int numCourses = 4;
        System.out.println(canFinish(numCourses, prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] inDegree = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < n; i++) {
            for (int ele : adj.get(i)) {
                inDegree[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);

            for (int item : adj.get(node)) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    q.add(item);
                }
            }
        }
        System.out.println(topo);
        return topo.size() == n;
    }


}
