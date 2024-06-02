import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CanVisitAllrooms {
    public static void main(String[] args) {
        
        int[][] rooms = {
            {1,3},
            {3,0,1},
            {2},
            {0}
        };
        canVisitAllRooms(rooms);

    }
    public static void canVisitAllRooms(int[][] rooms) {
        boolean[] visit = new boolean[rooms.length];
        visit[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neibhour : rooms[node]) {
                if (!visit[neibhour]) {
                    visit[neibhour]= true;
                    stack.push(neibhour);
                }
            }
        }
        for (boolean visited : visit) { 
            if (!visited) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
