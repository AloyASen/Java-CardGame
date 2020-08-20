public class PlayingState implements State {

    public void doAction(Context context) {
       System.out.println("Player is in playing state");
       context.setState(this);	
    }
 
    public String toString(){
       return "Playing";
    }
 }