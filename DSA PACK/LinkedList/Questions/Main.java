public class Main {
    public static void main(String[] args) {
        LinkedList list  = new LinkedList();
        list.insert(2);;
        list.insert(3);
        list.insert(5);
        list.insert(9);
        list.display();
        list.insertRec(8, 2);
        list.display();
    }
}
