public class Middle_Of_LL {
    public MeargeTwoLinkedList middle(MeargeTwoLinkedList.Node head){
        MeargeTwoLinkedList.Node f = head;
        MeargeTwoLinkedList.Node s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
