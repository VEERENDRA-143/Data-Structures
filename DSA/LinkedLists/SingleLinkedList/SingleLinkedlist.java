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