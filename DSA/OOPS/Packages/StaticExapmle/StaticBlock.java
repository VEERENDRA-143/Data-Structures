package Packages.StaticExapmle;

// Intilizing static varibles
public class StaticBlock {
    static int age = 4;
    static int b;

    static {
        System.out.println("It is Static Block");
        
        b = age*5;
    }

    public static void main(String[] args) {
        StaticBlock o = new StaticBlock();
        System.out.println(o.age + " "+o.b );
        o.b+=5;
        System.out.println(o.b);

        StaticBlock o2 = new StaticBlock();
        System.out.println(o2.b);
    }
}
