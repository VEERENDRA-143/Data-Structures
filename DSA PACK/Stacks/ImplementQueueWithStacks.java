//Implementing Queue with Stacks

public class ImplementQueueWithStacks {
    protected int firstStack[];
    protected int secondStack[];
    private static final int final_size=10;

    private  int ptr1 = -1;

    private int ptr2 =-1;
    public ImplementQueueWithStacks(){
        this(final_size);
    }

    public ImplementQueueWithStacks(int Size) {
        this.firstStack = new int[Size];
        this.secondStack = new int[Size];
    }

    public void add(int value){
        if (isFull()){
            System.out.println("stack is Full !!!");
            return;
        }
        ptr1++;
        firstStack[ptr1]=value;
    }

    public void remove(){

        if (isEmpty()){
            System.out.println("Stack is Empty! No element to pop");
            return;
        }

//        Copying values into second stack to get the FIFO property
        while (ptr1 !=-1){
            ptr2++;
            secondStack[ptr2] = firstStack[ptr1--];
        }

        System.out.println(secondStack[ptr2--]);

//        Reassigns to the original data from second stack After removing the first element in stack

        while (ptr2 !=-1){
            ptr1++;
            firstStack[ptr1] = secondStack[ptr2--];
        }
    }

    public void peek(){
        System.out.println(firstStack[ptr1]);
    }

    private boolean isEmpty() {
        return  ptr1 ==0;
    }

    private boolean isFull() {
        return  ptr1 == firstStack.length-1;
    }

    public  void display(){
        for (int i = 0; i < ptr1 +1; i++) {
            System.out.print(firstStack[i]+" -> ");
        }
        System.out.println("TOP");
    }

    public static void main(String[] args) {
        ImplementQueueWithStacks queue =  new ImplementQueueWithStacks(5);
        queue.add(2);
        queue.add(4);
        queue.add(5);
        queue.add(9);
        queue.add(8);
        queue.display();
        queue.remove();
        queue.display();
        queue.add(7);
        queue.add(6);
        queue.add(1);
        queue.remove();
        queue.display();

    }
}
