package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(6);
        list.insertFirst(9);
        list.insertLast(100);
        list.display();
    }
}
