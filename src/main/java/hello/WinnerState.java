public class WinnerState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in Winner state");
        context.setState(this);
    }
    public String toString(){
        return "Winner";
    }
}
