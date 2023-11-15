
public class BoxWeight extends Box{
    
    double weight;
    public BoxWeight(){
        this.weight = 24.4;
    }

    public BoxWeight(double l, double h, double w, double weight) {
       
        super(l, h, w); 
        this.weight = weight;
    }

    public static void main(String[] args) {
        BoxWeight ob = new BoxWeight();
        System.out.println(ob.weight);
    }
}
