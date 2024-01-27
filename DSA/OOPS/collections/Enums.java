public class Enums {
    enum Week implements A {
        Monday, tuesday, Wednesday, Thursday, Friday, saturday;
        Week(){
            System.out.println("Constructed call for "+this);
        }

        @Override
        public void hello() {
            System.out.println("Unimplemented method 'hello'");
        }
    }
    
    public static void main(String[] args) {
        Week week;
        week  = Week.Monday;
        week.hello();
        // System.out.println(week);
        // System.out.println(week.ordinal());
        System.out.println(week.valueOf("Monday"));
    }
}
