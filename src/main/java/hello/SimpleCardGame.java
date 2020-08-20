package hello;

// this is the game
public class SimpleCardGame {

   //the deck of 52 cards in this game
   Deck deck = new Deck();
   
   // materialize the 4 players 
   Player plyr1;
   Player plyr2;
   Player plyr3;
   Player plyr4;
   // check the game level -> initlially 0
   int _isOn=0;
   // should the Game (Context) cashout and contract to exist!?
   boolean isEnded = false;
   // while creating the game iintialize the players and make the deck 
    public SimpleCardGame(Player plyr1, Player plyr2, Player plyr3, Player plyr4){
        // initialize the three players
        this.plyr1= plyr1;
        this.plyr2= plyr2;
        this.plyr3= plyr3;
        this.plyr4= plyr4;
       deck.init();// shuffles the deck as a shifter function // other processes can also be taken

    }
    // if player is 'Winner'/ 'loser' -> move to endCycle if tie -> step through
    private void checkPlayerStates(){

      // start the game 
      if (_isOn == 0){
        // this is a new game instance

      }

    }
    /* the game has 3 lifecycle medthods
      1. start : draw 3 cards for each player and  check the player states ... if playing .. contd >>
      2. step : draw a single card from the deck and check the player states ... if playing .. contd >>
      3. repeat step 2 ... until  any player 'WinnerState'/'loserState'
      4. implement and output as scheme :: 'One Winner and {{ALL others losers}} for the game ' 
    */
    public int start() {
      _isOn =1; 
      // draw three cards 
      // compare them to check tie / end state
        return 0;
    }
    public int  step(){
      _isOn +=1;

        return 0;
    }
    public void end() {

        isEnded =true;
    }
 

 }