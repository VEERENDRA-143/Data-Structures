public class MinimumTargetToreachScore {
    public static void main(String[] args) {
        int target = 999999998;
        int maxDoubles = 0;
        minMoves(target, maxDoubles);
    }
    public static void minMoves(int target, int maxDoubles) {
        if (maxDoubles == 0) {
            System.out.println(target-1);
            return;
        }
        int count=0;
        while (target != 1) {
            
            if (maxDoubles != 0 && target%2 == 0){
                target /= 2;
                maxDoubles--;
            }
            else{
                target--;
            }
            count++;
        }
        System.out.println(count);
    }
}
