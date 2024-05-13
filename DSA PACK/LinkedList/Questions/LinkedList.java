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

    public void delete(int num){
        int index = 0;
        Node temp = head;
        while (temp.value != num) {
            index++;
        }
        int step = 0;
        Node ans = head;
        while (step != index-1) {
            ans = ans.next;
            step++;
        }
        ans= ans.next;
    }

    public void removeNodes(){
        removeNodes(head);
    }

    public Node removeNodes(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node dummyHead = new Node(-1);
        Node tempPrev = dummyHead;
        curr = prev;

        while (curr != null) {
            if (curr.value >= tempPrev.value) {
                tempPrev.next = curr;
                tempPrev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
        tempPrev.next = null;

        Node newPrev = null, newCurr = dummyHead.next;
        while (newCurr != null) {
            Node next = newCurr.next;
            newCurr.next = newPrev;
            newPrev = newCurr;
            newCurr = next;
        }

        return newPrev;
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