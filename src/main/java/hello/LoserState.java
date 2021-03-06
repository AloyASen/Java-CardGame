package hello;

public class LoserState implements State {
    @Override
    public void doAction(Player context) {
        System.out.println("Player is in Loser state");
        context.setState(this);
    }
    @Override
    public String toString(){
        return "Loser";
    }
}