public class ReplaceChalk {
    public static void main(String[] args) {
        int[] chalk ={3,4,1,2 };
        int k = 25;
        System.out.println(chalkReplacer(chalk, k));
    }
    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int sum = 0;
        for(int e : chalk){
            sum+=e;
        }
        int rem = k % sum;
        for(int i = 0;i < n;i++){
            if(rem >= chalk[i]){
                rem -= chalk[i];
            }else{
                return i;
            }
        }
        return 0;
    }
}
