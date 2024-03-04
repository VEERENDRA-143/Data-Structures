public class CustomStack {
    
    protected int[] data;
    private static final int Final_Size=10;
    int ptr = -1;

    public CustomStack(){
        this(Final_Size);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){

        if (isFull()) {
            System.out.println("Stack is Full!!");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;

    }

    public int pop() throws Exception{
        if (isEmpty()) {
            throw new Exception("Stack is Empty ! Con't POP the element");
        }
        return data[ptr--];
    }

    public int peek() throws Exception{
        if (isEmpty()) {
            throw new Exception("Stack is Empty ! Con't POP the element");
        }
        return data[ptr];
    }

    protected boolean isFull() {
      return ptr == data.length-1;
    }
    private boolean isEmpty(){
        return ptr==-1;
    }

    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack(5);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(10);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
