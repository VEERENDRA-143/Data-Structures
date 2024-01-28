
public class Main {
    public static void main(String[] args) {
        SingleLinkedlist list = new SingleLinkedlist();
        list.inserFirst(2);
        list.inserFirst(8);
        list.inserFirst(9);
        list.inserFirst(4);
        list.insertLast(7);
        list.insert(10, 3);


        list.diplay();
        System.out.println("\n");
        System.out.println(list.deleteFirst());
        // System.out.println(list.deleteLast());
        System.out.println(list.delete(0));
        System.out.println();
        list.diplay();
    }
}
