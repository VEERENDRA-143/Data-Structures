package Interfaces;

public class CDplayer implements Media{

    @Override
    public void start() {
        System.out.println("Cd player start");
    }

    @Override
    public void stop() {
        System.out.println("CD player stop");
    }
    
}
