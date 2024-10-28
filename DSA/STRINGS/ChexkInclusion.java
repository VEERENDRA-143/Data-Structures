import java.util.ArrayList;

public class ChexkInclusion {
    public static void main(String[] args) {
        String s1= "adc";
        String s2= "dcda";
        boolean ans = checkInclusion(s1,s2);
        System.out.println(ans);
    }

    public static boolean checkInclusion(String s1, String s2) {
        ArrayList<Integer>  list = new ArrayList<>();
        boolean check = checkChars(s1,s2,list);
        if(check == false) return false;
        System.out.println(list);
        for(int i = 1; i < list.size(); i++){
            if((Math.abs(list.get(i) - list.get(i-1))) != 1 ){
                return false;
            }
        }
        return true;
    }

    public static boolean checkChars(String s1, String s2,ArrayList<Integer> list){
        
        for(char ch : s1.toCharArray()){
            int index = s2.indexOf(ch) ;
            if(index < 0){
                return false;
            }else{
                list.add(index);
            }
        }
        System.out.println(list);
        return true;
    }

}
