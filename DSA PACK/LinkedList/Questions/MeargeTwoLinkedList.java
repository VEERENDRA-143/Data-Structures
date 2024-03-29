
public class MeargeTwoLinkedList {
    
    Node head;
    Node tail;
    private int size;
    public MeargeTwoLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail==null) {
            tail = head;
        }
        size++;
    }
    public void insertLast(int value){
        Node node = new Node(value);
        if (head==null) {
            insertFirst(value);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
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
        public Node(int value,Node next){
            this(value);
            this.next = next;
        }
        
    }
    // Mearge Two Sorted Lists
    public static MeargeTwoLinkedList mearge(MeargeTwoLinkedList list1,MeargeTwoLinkedList list2){
        Node first = list1.head;
        Node second = list2.head;
        MeargeTwoLinkedList ans = new MeargeTwoLinkedList();
        while (first != null && second != null) {
            if (first.value <= second.value) {
                ans.insertLast(first.value);
                first = first.next;
            }
            else{
                ans.insertLast(second.value);
                second = second.next;
            }
        }

        while (first != null) {
            ans.insertLast(first.value);
            first = first.next;
        }
        while (second != null) {
            ans.insertLast(second.value);
            second = second.next;
        }
        return ans;
    }
    
    // reverese using Recursion
    public void reverse(Node node){
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public Node  revrse(Node head){
        if (head == null) {
            return head;
        }
        Node prvious = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prvious;
            prvious = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prvious;
    }

   

    public static void main(String[] args) {
        MeargeTwoLinkedList list = new MeargeTwoLinkedList();
        MeargeTwoLinkedList list2 = new MeargeTwoLinkedList();

        list.insertLast(1);
        list.insertLast(3);
        list.insertLast(5);

        
        list2.insertLast(5);
        list2.insertLast(3);
        list2.insertLast(1);

        list.display();
        list2.display();
        MeargeTwoLinkedList ans = MeargeTwoLinkedList.mearge(list,list2);
        ans.display();
        ans.revrse();
        ans.display();

    }
}
