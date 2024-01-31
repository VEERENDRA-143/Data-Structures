public class LinkedList {

    Node head;
    Node tail;
    private int size;

    public LinkedList(){
        this.size=0;
    }
    public void insert(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail==null) {
            tail = head;
        }
    }
    public void insertRec(int value,int index){
        head = insertRec(value, index, head);
    }

    private Node insertRec(int value,int index,Node node){
        if (index==0) {
            Node temp = new Node(value,node);
            size++;
            return temp;
        }
        node.next = insertRec(value, index-1, node.next);
        return node;
    }

    public void display(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    
    class Node {
        
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this(value);
            this.next = next;
        }
        
    }
    
}