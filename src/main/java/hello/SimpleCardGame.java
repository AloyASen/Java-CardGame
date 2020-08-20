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
    Player Winner =null; // this has to be satisfied per round
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
        PlayingState gameState =new PlayingState();
      _isOn =1; 
      // draw three cards for each player
        plyr1.setCards(deck.draw3cards());
        plyr1.setState(gameState);

        plyr2.setCards(deck.draw3cards());
        plyr2.setState(gameState);

        plyr3.setCards(deck.draw3cards());
        plyr3.setState(gameState);

        plyr4.setCards(deck.draw3cards());
        plyr4.setState(gameState);

        System.out.println("all the 4 players get the initial set of cards :: 3 each");
      // compare them to check tie / end state
        return 0; // for testing purposes TODO
    }
    public int  step(){
      _isOn +=1;
      // all the players draw a new card
        plyr1.drawAnotherCard(deck.drawCard());
        plyr2.drawAnotherCard(deck.drawCard());
        plyr3.drawAnotherCard(deck.drawCard());
        plyr4.drawAnotherCard(deck.drawCard());
        return 0;
    }
    public void end() {
        // set all the players to the end state Winner/Loser
        isEnded =true;
    }
 

 }