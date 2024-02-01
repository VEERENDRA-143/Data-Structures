
// To slove this we use " Fast and slow pointers Method "
// Fast = moves ahead by two steps
// Slow = moves ahead by one step
// whenever the fast and slow meet to each other the cycle is present

public class Check_Cycle_is_Present {
    public static void main(String[] args) {
        
    }
    public static boolean hasCycle(MeargeTwoLinkedList.Node head) {
        MeargeTwoLinkedList.Node fast = head;
        MeargeTwoLinkedList.Node slow = head;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
