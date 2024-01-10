package AbstractClasses;

public class Child extends Parent{

    public Child(int age) {
        super(age);
        
    }

    @Override
    void Carrer(String name) {
        System.out.println("I am "+ name);
    }

    @Override
    void partener(String name, int age) {
       System.out.println("Name is : "+ name+ " age is : "+age);
    }
    
}
