//package SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedlist list1 = new SingleLinkedlist();
        list1.insertLast(4);
        list1.insertLast(2);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.diplay();
        System.out.println();
        // list1.pairSum();

        System.out.println(list1.removeNthFromEnd(3));
        // System.out.println(list.find(2));
        // System.out.println("\n");
        // System.out.println(list.deleteFirst());
        // // System.out.println(list.deleteLast());
        // System.out.println(list.delete(0));
        // System.out.println();
        // list.diplay();
    }
}
