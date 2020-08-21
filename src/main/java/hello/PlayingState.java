package hello;

public class PlayingState implements State {
    @Override
    public void doAction(Player context) {
        System.out.println("Player is in playing state");
        context.setState(this);
    }

    @Override
    public String toString(){
       return "Playing";
    }
 }