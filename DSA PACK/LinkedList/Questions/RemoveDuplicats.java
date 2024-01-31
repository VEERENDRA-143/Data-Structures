public class RemoveDuplicats {
    Node head;
    Node tail;
    private int size;
    public RemoveDuplicats(){
        this.size=0;
    }
    public void insert(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail==null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if (tail == null) {
            insert(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void  duplicate(){
        Node node = head;
        while (node.next!=null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            }
            else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node next){
            this(value);
            this.next = next;
        }
        
    }
    public static void main(String[] args) {
        RemoveDuplicats list = new RemoveDuplicats();
        list.insertLast(2);
        list.insertLast(4);
        list.insertLast(9);
        list.insertLast(4);
        list.display();
        list.duplicate();
        list.display();
    }
}
