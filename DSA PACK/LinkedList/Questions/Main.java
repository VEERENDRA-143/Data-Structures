public class Main {
    public static void main(String[] args) {
        LinkedList list  = new LinkedList();
        list.insert(8);
        list.insert(3);
        list.insert(13);
        list.insert(2);
        list.insert(5);
        
        list.display();
        list.removeNodes();
        list.display();
    }
}
