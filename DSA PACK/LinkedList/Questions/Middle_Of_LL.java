public class Middle_Of_LL {
    public ListNode middle(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
