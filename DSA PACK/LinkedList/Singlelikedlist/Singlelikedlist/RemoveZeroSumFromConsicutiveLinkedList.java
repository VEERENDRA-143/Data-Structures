package Singlelikedlist;

public class RemoveZeroSumFromConsicutiveLinkedList extends LinkedList{
    
    public void removeZeroSumSublists(){
        Node p1 = head;
        Node p2 = head;
        int sum = 0;
        int temp;
        while (p1 !=  null) {
            System.out.println("p1 - "+p1.value + " -> ");
            temp = p1.value;
            sum=temp;
            System.out.println("Temp = "+temp);
            while (p2 != null) {
                System.out.print("p2 - "+p2.value + " -> ");
                if (p1 != p2) {
                    sum +=  p2.value ;
                    if (sum==0) {
                        System.out.println("You Got Answer ! Sum = "+sum);
                        head = p2;
                        display();
                        return;
                    }
                }
                p2 = p2.next;
            }
            System.out.println("sum = "+sum);
            // System.out.println();
            p1 = p1.next;
            p2 = head.next;
            head=head.next;
            display();
            // temp=0;
        }
    }
}
