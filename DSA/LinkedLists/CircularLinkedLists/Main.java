public class Main {
    public static void main(String[] args) {
        
        CircularLists list = new CircularLists();
        list.insert(3);
        list.insert(6);
        list.insert(9);
        list.insert(8);
        list.insert(4);
        list.insert(2);
        list.display();
        list.delete(9);
        list.display();

    }
}
