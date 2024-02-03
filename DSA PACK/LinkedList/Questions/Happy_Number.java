public class Happy_Number {
    public boolean ishappy(int n){
        int slow = n;
        int fast = n;

        do {
            slow = fintsquare(n);
            fast = fintsquare(fintsquare(n));
        } while ( fast != slow);

        if (slow==1) {
            return true;
        }
        return false;
    }

    private int fintsquare(int number){
        int ans = 0;

        while (number != 0) {
            int rem = number %10;
            ans = rem*rem;
            number = number/10;
        }
        return ans;

    }
}
