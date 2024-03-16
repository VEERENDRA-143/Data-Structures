
public class Min{
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insertLast(2);
        list.insertLast(4);
        list.insertLast(3);
        

        LinkedList list2 = new LinkedList();
        list2.insertLast(5);
        list2.insertLast(6);
        list2.insertLast(4);


        list.display();
        list2.display();

        int num1 = list.addTwoNumbers();
        int num2 = list2.addTwoNumbers();

        System.out.println(num1+num2);

        AddingNums add = new AddingNums();
        // add.addTwoNumbers(list, list2);
    }
}
