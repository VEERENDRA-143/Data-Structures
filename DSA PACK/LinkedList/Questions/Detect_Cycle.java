public class Detect_Cycle {
    public MeargeTwoLinkedList.Node DetectCycle(MeargeTwoLinkedList.Node head){
        int length=0;
        MeargeTwoLinkedList.Node fast = head;
        MeargeTwoLinkedList.Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = FindLengthOfCycle.LengthCycle(slow);
                break;
            }
        }

        if (length==0) {
            return null;
        }
        MeargeTwoLinkedList.Node f = head;
        MeargeTwoLinkedList.Node s = head;

        while (length>0) {
            s = s.next;
            length--;
        }

        while (f !=  s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
