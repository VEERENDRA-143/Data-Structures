import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeimp {
    public static void main(String[] args) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(2);
        deque.addFirst(4);
        System.out.println(deque);
        deque.addLast(5);
        System.out.println(deque);
        deque.remove();
        System.out.println(deque);

    }
}
