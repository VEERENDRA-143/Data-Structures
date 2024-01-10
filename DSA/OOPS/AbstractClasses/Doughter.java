package AbstractClasses;

public class Doughter extends Parent{

    public Doughter(int age) {
        super(age);
        
    }

    @Override
    void Carrer(String name) {
        System.out.println("Doughter carere = "+name);
    }

    @Override
    void partener(String name, int age) {
        System.out.println("Daughters parterner is  "+name+" And Age is "+age);
    }
    
}
