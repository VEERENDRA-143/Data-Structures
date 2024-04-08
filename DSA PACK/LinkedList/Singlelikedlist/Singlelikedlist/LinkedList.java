

class LinkedList {
    Node head;
    Node tail;

    private int size;
    public LinkedList(){
        this.size=0;
    }

    public void insertFirst(int value){

        Node node  = new Node(value);
        node.next=head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size+=1;
    }

    public void insertLast(int value){
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail=node;
    }

    public void insert(int value, int index){
        if (index==0) {
            insertFirst(value);
            return;
        }
        if (index==size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node  =  new Node(value, temp.next);
        temp.next = node;
    }

    

    public void display(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.value +" -> ");
            temp = temp.next;
        }
        System.out.println("END");

    }

    public void swapPairs(){
        Node slowNode = head;
        Node fastNode = head.next;

        while (fastNode != null ) {

            System.out.println(slowNode.value);
            System.out.println(fastNode.value);
                
            fastNode.next = slowNode;
            slowNode.next = fastNode.next.next;
            if (fastNode != null) {
                slowNode = fastNode.next;
            }
            if (slowNode != null) {
                fastNode = slowNode.next;
            }else{
                fastNode = null;
            }

        }
    }

    public void hasCycle() {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println(fast.value);
            System.err.println(slow.value);
        }
    }

    public void removeZeroSumSublists(){
        Node p1 = head;
        Node p2 = head;
        int sum = 0;
        int temp;
        while (p1 !=  null) {
            System.out.println("p1 - "+p1.value + " -> ");
            temp = p1.value;
            sum=temp;
            System.out.println("Temp = "+temp);
            while (p2 != null) {
                System.out.print("p2 - "+p2.value + " -> ");
                if (p1 != p2) {
                    sum +=  p2.value ;
                    if (sum==0) {
                        System.out.println("You Got Answer ! Sum = "+sum);
                        head = p2;
                        display();
                        return;
                    }
                }
                p2 = p2.next;
            }
            System.out.println("sum = "+sum);
            // System.out.println();
            p1 = p1.next;
            p2 = head.next;
            head=head.next;
            display();
            // temp=0;
        }
    }
    
    



    public int addTwoNumbers(){
        Node p1 = head;
        int num=0;
        String s="";
        while (p1!=null) {
            s= s+p1.value;
            p1 = p1.next;
        }
        System.out.println();
        int length1 = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
            num += (s.charAt(i)-48)*(Math.pow(10,length1));
            length1 = length1-1;
        }
        

        return num;

    }



    class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    
}