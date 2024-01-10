package Interfaces;

public class Car implements Engine,Break,Media{

    @Override
    public void breake() {
        System.out.println("Car brake");
    }

    @Override
    public void start() {
        System.out.println("Car engine start");
    }

    @Override
    public void stop() {
        System.out.println("car engine Stop");
    }

    @Override
    public void Acc() {
        System.out.println("Car Accelerate");
    }
    
}
