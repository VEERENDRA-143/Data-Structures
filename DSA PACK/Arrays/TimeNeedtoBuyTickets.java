public class TimeNeedtoBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        int k=3;
        timeRequiredToBuy(tickets, k);
    }
    public static void timeRequiredToBuy(int[] tickets, int k) {
        int count=0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    tickets[i] = tickets[i]-1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
