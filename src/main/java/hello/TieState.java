package hello;

public class TieState implements State{
    @Override
    public void doAction(Player context) {
        System.out.println("Player is in Tie state");
        context.setState(this);
    }
    @Override
    public String toString(){
        return "Tie";
    }
}
