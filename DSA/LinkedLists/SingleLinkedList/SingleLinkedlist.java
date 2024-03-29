// package SingleLinkedList;
import java.util.*;
public class SingleLinkedlist {

    private Node head;
    private Node tail;

    private int size;

    public SingleLinkedlist() {
        this.size = 0;
    }

    // Insert element at starting of the linked list

    public void inserFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    // Insert element at Ending of the linked list

    public void insertLast(int val) {
        if (tail == null) {
            inserFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // Insert Elements in Given index
    public void insert(int value, int index) {
        if (index == 0) {
            inserFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
    }

    // Deleting the First Element
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // Deleting the Last Element
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secodLast = get(size - 1);
        // System.out.println(secodLast);
        int val = tail.value;
        tail = secodLast;
        tail.next = null;
        return val;
    }

    // delete the value based on index
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node previous = get(index - 1);
        int val = previous.next.value;
        previous.next = previous.next.next;
        return val;
    }

    public void mergeInBetween(Node list1, Node list2, int a, int b) {

        Node first = list1;
        Node second = list1;
        Node ans = first;
        int i = 1;
        int j = 0;
        while (i < a) {
            first = first.next;
            i++;
        }
        while (j < b) {
            second = second.next;
            j++;
        }
        first.next = list2;
        Node secon = list2;
        while (secon.next != null) {
            secon = secon.next;
        }
        secon.next = second.next;

    }

    public int removeNthFromEnd(int n){
        Node temp = head;
        int count=0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int fromFirst = count-n;

        return count;

    }

    public Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    // Get Reference
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    // displaying Elements

    public int getDecimalValue(){
        Node node = head;
        Node temp = head;
        int count =0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Actual count = "+count);
        int ans=0;
        count = count-1;
        while (node != null && count!=-1) {
            System.out.println("node.value = "+ node.value);
            ans = ans + node.value*((int)Math.pow(2, count));
            System.out.println("ans = "+ans);
            count--;
            node = node.next;
        }
        System.out.println("Desimal Number is : "+ans);
        return ans;
    }

    public void insertGreatestCommonDivisors(){
        Node temp = null;
        Node node  = head;
        while (node.next!=null) {
            temp = node;
            node = node.next;
            int num1 = temp.value;
            int num2 = node.value;
            int gcd = findGCD(num1,num2);
            Node newNode = new Node(gcd);
            newNode.next=temp.next;
            temp.next = newNode;
        }
    }

    private int findGCD(int num1, int num2) {
       
        if (num2 == 0)   
            return num1; 

        return findGCD(num2, num1 % num2); 
    }

    public void doubleIt(){
        Node temp = head;
        Node node = head;
        int count=0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int sum =0 ;
        count--;
        
        while (node !=  null) {
            sum = sum+(node.value*(int)Math.pow(10, count));
            count--;
            node = node.next;
        }
        sum +=sum;
        System.out.println("sum = "+sum);
        int dummySum = sum;
        int sumCount=0;
        while (dummySum !=0) {
            sumCount++;
            dummySum = dummySum/10;
        }
        System.out.println(sumCount);
        int refer = sumCount-1;
        SingleLinkedlist list = new SingleLinkedlist();
        while (refer!=-1) {
            int q = sum/(int)Math.pow(10, refer);
            System.out.println("q = "+q);

            list.insertLast(q);
            System.out.println("q = "+ q);
            sum = sum % (int)Math.pow(10, refer);
            System.out.println();
            refer--;
        }
        list.diplay();
    }

    public void swapNodes(int k){
        Node temp = head;
        Node node = head;
        Node node2 = head;
        int count=0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int fromFirst = count-k;
        
        while (k > 0) {
            node = node.next;
            k--;
        }
        while (fromFirst>0) {
            node2 = node2.next;
            fromFirst--;
        }
        int a = node.value;
        node.value = node2.value;
        node2.value = a;
        diplay();
    }

    public void diplay() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public int pairSum(){
        Node temp = head;
        ArrayList<Integer> list =  new ArrayList<>();

        while (temp != null) {
            list.add(temp.value);
            temp = temp.next;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        int start =0;
        int end = list.size()-1;
        int max=0;
        while (start<=end) {
            int sum = list.get(start)+list.get(end);
            max = Math.max(max, sum);
            start++;
            end--;
        }
        return max;
    }

    public void reorderList(){
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow.value);
        Node dummy = slow.next;
        // System.out.println(dummy.value);
        
        // Reverse LL from mid to end
        Node prvious = null;
        Node present = dummy;
        Node next = present.next;
        while (present != null) {
            present.next = prvious;
            prvious = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }


        SingleLinkedlist list = new SingleLinkedlist();
        while (prvious != null) {
            // System.out.print(prvious.value+" -> ");
            // System.out.println(head.value + "=>");
            
            list.insertLast(head.value);
            list.insertLast(prvious.value);
            
            prvious = prvious.next;
            head = head.next;
        }
        list.diplay();
    }

    // Createing a Node [ Node have its value and pointer to next-node ]
    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}