public class Reverse_LL_given_range {
     // Reverese Linked List in Given Range
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // skip first first left-1 nodes
        ListNode current = head;
        ListNode prvious = null;

        for (int i = 0; current !=null && i < left-1 ; i++) {
            prvious = current;
            current = current.next;
        }
        ListNode last = prvious;
        ListNode newEnd = current;

        // Revrese B/W left and Right
        ListNode next = current.next;
        for (int i = 0; i < (right - left) + 1; i++) {
            current.next = prvious;
            prvious = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prvious;
        }
        else{
            head = prvious;
        }

        newEnd.next = current;

        return head;
    }


    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = middleNode(head);
        ListNode headsecond = reverse(mid);

        ListNode rereverseHead = headsecond;

        while (head != null && headsecond != null) {
            if (head.value != headsecond.value) {
                break;
            }
            head = head.next;
            headsecond = headsecond.next;
        }

        reverse(rereverseHead);

        return head == null || headsecond ==null;
    }


    // private ListNode reverse(ListNode node) {
    //     if (node == tail) {
    //         head = tail;
    //         return;
    //     }
    //     reverse(node.next);

    //     tail.next = node;
    //     tail = node;
    //     tail.next = null;
    // }
        


    private ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }



}

