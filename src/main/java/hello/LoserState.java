public class LoserState implements State {
    public void doAction(Player context) {
        System.out.println("Player is in Loser state");
        context.setState(this);
    }
    public String toString(){
        return "Loser";
    }
}