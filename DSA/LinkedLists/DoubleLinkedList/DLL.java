package DoubleLinkedList;

public class DLL {

    Node head;

    public void insertFirst(int value){
        Node node  = new Node(value);
        
        node.next = head;
        node.previous= null;
        if (head!=null) {
            
            head.previous = null;
        }
        head = node;
    }


    public void insertLast( int value){
        Node node  = new Node(value);
        Node last = head;
        if (head == null) {
            node.previous = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.previous = last;
    }


    public void display(){
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last=node;
            node = node.next;
        }
        System.out.println("END");


        System.out.println("Reverse");
        while (last != null) {
            System.out.println(last.val+" -> ");
            last = last.previous;
        }
        System.out.println("start");
    }





    private class Node {
    
        int val;
        Node next;
        Node previous;

        public Node(int val){
            this.val  = val;
        }

        public Node(int val,Node next, Node previous){
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }
}
