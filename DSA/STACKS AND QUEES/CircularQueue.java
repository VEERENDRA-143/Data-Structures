public class CircularQueue {
    protected int[] data;

    private static int QueSize = 10;

    protected int end = 0;
    protected int front=0;
    private int size=0;

    public CircularQueue() {
        this(QueSize);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    protected boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return front == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue Is Full !!");
            return false;
        }
        data[end] = item;
        end++;
        end = end%data.length;
        size++;
        return true;
    }

    public int remove(){
        int removed = data[front];
        front = front%data.length;
        size--;
        front++;
        return removed;
    }
    public void display() {
        for (int i = front; i < size; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(2);
        queue.insert(4);
        queue.insert(8);
        queue.insert(3);
        queue.insert(9);
        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}
