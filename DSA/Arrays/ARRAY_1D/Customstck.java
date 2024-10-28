public class Customstck {
    int[] stack;
    int size;
    int ind;
    public Customstck(int maxSize) {
        this.size = maxSize;
        this.ind = -1;
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(ind < size-1){
            stack[++ind] = x;
        }
        // stack.add(x);
    }
    
    public int pop() {
        return ind>=0 ? stack[ind--]: -1;
    }
    
    public void increment(int k, int val) {
        int indes = Math.min(k,ind+1);
        for(int i = 0; i< indes ; i++){
            stack[i] += val;
        }
    }
    public static void main(String[] args) {
        Customstck stack = new Customstck(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
