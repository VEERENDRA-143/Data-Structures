package Polymorhism;

public class Circles extends Shapes{
   
    double Circle(double r){
        return 4*r;
    }
    public static void main(String[] args) {
        Shapes obj = new Circles();
        System.out.println(obj.Circle(3));
    }
}
