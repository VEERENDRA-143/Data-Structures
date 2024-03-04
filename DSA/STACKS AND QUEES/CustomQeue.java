public class CustomQeue {

    protected int[] data;

    private static int QueSize = 10;

    public int end = 0;

    public CustomQeue() {
        this(QueSize);
    }

    public CustomQeue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            System.out.println("Queue Is Full !!");
            return false;
        }
        data[end] = item;
        end++;
        return true;
    }

    public int remove(){
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    protected boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty() {
        return end == 0;
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        CustomQeue queue = new CustomQeue(5);
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
