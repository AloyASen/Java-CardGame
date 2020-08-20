public class NewPlayer implements State {

    public void doAction(Context context) {
       System.out.println("Player is wating to play state");
       context.setState(this);	
    }
 
    public String toString(){
       return "New";
    }
 }