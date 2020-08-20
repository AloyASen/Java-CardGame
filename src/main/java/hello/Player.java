// each player has a state of activity
public class Player{
    // the state of the game Play
    private State state;
    // the player name 
    public name;
    // the list of the cards drawn by the user
    public Player(this.name) {
       super();
       // initialize the player as   NEW state 
      this. state = new NewPlayer ;
    }
    List cards = [];
    public void setState(State state){
        this.state = state;		
     }
  
     public State getState(){
        return state;
     }    
}