import java.util.LinkedList;
import java.util.Queue;

public class QueesInbuild {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(4);
        queue.add(6);
        queue.add(9);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        
    }
}
