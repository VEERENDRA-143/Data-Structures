import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NoOfStudentsUebleToEat {
    public static void main(String[] args) {
        int[] students={1,1,0,0} ;
        int[] sandwiches={0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
    }

    // No. Of student Enable to Eat sandwiches.
    public static int countStudents(int[] students, int[] sandwiches) {
        if (students.length!=sandwiches.length) {
            return -1;
        }

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int ele : students) {
            queue.add(ele);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length-1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        while(!queue.isEmpty()) {
            if (queue.contains( stack.peek())) {
                // Check For student is enable to eat or not.
                if (stack.peek()==queue.peek()) {
                    // Remove element from the Queues and Stacks
                    stack.pop();
                    queue.poll();
                    count++;
                }
                else{
                    // Rotate Queue
                    int student = queue.poll();
                    queue.add(student);
                }
            }
            else{
                return queue.size();
            }
        }

        return queue.size();
    }

}
