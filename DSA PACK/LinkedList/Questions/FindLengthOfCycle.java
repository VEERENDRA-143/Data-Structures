public class FindLengthOfCycle {
    
    public static int LengthCycle(MeargeTwoLinkedList.Node head) {
        MeargeTwoLinkedList.Node fast = head;
        MeargeTwoLinkedList.Node slow = head;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){

                MeargeTwoLinkedList.Node temp = slow;
                int length = 0;
                do {

                    temp = temp.next;
                    length++;

                } while (temp!= slow);
                
                return length;

            }
        }
        return 0;
    }
}
