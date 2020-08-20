package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// this is the game
public class SimpleCardGame {

   //the deck of 52 cards in this game
   Deck deck = new Deck();
   
   // materialize the 4 players NOTE:: also extensible
   List<Player> Plyrs =new ArrayList<>();
   //memcached copy
    Player[] copyPlayers ;
   // check the game level -> initially 0
   int _isOn=0;
   // should the Game (Context) cashout and contract to exist!?
   boolean isEnded = false;
   // while creating the game initialize the players and make the deck
    public SimpleCardGame(Player plyr1, Player plyr2, Player plyr3, Player plyr4){
        // initialize the four players
        Plyrs.add(plyr1);
        Plyrs.add(plyr2);
        Plyrs.add(plyr3);
        Plyrs.add(plyr4);
        //initialize tihe copy players to for this game object
        copyPlayers = new Player[Plyrs.size()];
        Plyrs.toArray(copyPlayers);
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

        for (Player pie:
             copyPlayers) {
            pie.setCards(deck.draw3cards());
            pie.setState(gameState);

        }


        System.out.println("all the 4 players get the initial set of cards :: 3 each");
      // compare them to check tie / end state
        return 0; // for testing purposes TODO
    }
    public int  step(){
      _isOn +=1;
      // all the players draw a new card
        for (Player pie:
             copyPlayers) {
            pie.drawAnotherCard(deck.drawCard());
        }
        // compare them to check tie / end state

        return 0;
    }
    public void end() {
        // set all the players to the end state Winner/Loser
        isEnded =true;
    }
 

 }