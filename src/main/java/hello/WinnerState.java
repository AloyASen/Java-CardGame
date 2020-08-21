package hello;

public class WinnerState implements State {
    @Override
    public String toString(){
        return "Winner";
    }

    @Override
    public void doAction(Player context) {
        System.out.println("Player is in Winner state");
        context.setState(this);
    }
}
