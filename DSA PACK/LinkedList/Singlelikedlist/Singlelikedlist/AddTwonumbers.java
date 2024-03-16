public class AddTwonumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode currentNode = listNode;
        int number = 0;
        while (l1 != null || l2 != null || number != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += number;
            number = sum / 10;
            ListNode node = new ListNode(sum % 10);
            currentNode.next = node;
            currentNode = node;
        }

        return listNode.next;
    }

    public static void main(String[] args) {
        
    }
}
