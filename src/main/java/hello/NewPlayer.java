package hello;

public class NewPlayer implements State {


    @Override
    public String toString(){
       return "New";
    }

    @Override
    public void doAction(Player context) {
        System.out.println("Player is wating to play state");
        context.setState(this);
    }
}