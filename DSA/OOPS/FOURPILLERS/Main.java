public class Main {
    public static void main(String[] args) {
        // Box box = new Box();
        // Box box1 = new Box(2.3,4.5,6.7);
        // Box box2 = new Box(box1);
        // System.out.println(box.h + " "+ box.l + " "+box.w);
        // System.out.println(box1.h + " "+ box1.l + " "+box1.w);
        // System.out.println(box2.h + " "+ box2.l + " "+box2.w);

        BoxWeight ob = new BoxWeight();
        System.out.println(ob.weight);

        BoxWeight ob1 = new BoxWeight(2.3,4.5,5.6,7.8);
        System.out.println(ob1.l + " "+ ob1.h+" "+ob1.w +" "+ob1.weight);

        Box box1 = new BoxWeight();
        System.out.println(box1.w);
        

        
    }
}
