package hello;

import java.util.ArrayList;
import java.util.List;

// this is the game
public class SimpleCardGame {

   //the deck of 52 cards in this game
   Deck deck = new Deck();
   
   // materialize the 4 players NOTE:: also extensible
   List<Player> Plyrs =new ArrayList<>();
   //memcached copy
    Player[] copyPlayers ;
    // only instanciate if tie occurs in game check the states of Players
    List<Player> _tiePlay;

    Player Winner =null; // this has to be satisfied before end=> () call cycle
    Boolean isTie = false; // //check
   // check the game level -> initially 0
   int _isOn=0;
   // should the Game (Context) cashout and contract to exist!?
   boolean isEnded = false;
   // while creating the game initialize the players and make the deck
    public SimpleCardGame(Player plyr1, Player plyr2, Player plyr3, Player plyr4){
        System.out.println("Initializing the players and the deck");
        // initialize the four players
        Plyrs.add(plyr1);
        Plyrs.add(plyr2);
        Plyrs.add(plyr3);
        Plyrs.add(plyr4);
        //initialize the copy players to for this game object
        copyPlayers = new Player[Plyrs.size()];
        Plyrs.toArray(copyPlayers);
       deck.init();// shuffles the deck as a shifter function // other processes can also be taken

    }
    /* if any player is 'Winner' @return
    2 =  [ tie state ]
     1 = [ winner decided] else
     0= [ undecided -- need another step ]

    the game handler at Main () does the runn through here cardGame.class
     */
    private int checkPlayerStates(){
        int countSimilar=0; // local indicator for a tie value>=2
        Player earMarker =null;
        TieState tieState = new TieState();
     // check Trie State ... check if a __tie
        System.out.println("Checking for trie state for all players");
        for (Player pie:
             Plyrs) {
            if(pie.checkTriState()) {
                if (earMarker == null) {
                    earMarker = pie;
                } else {
                    // tie has occured
                    earMarker.setState(tieState);
                    //update the earmarker if any
                    earMarker = pie;
                    earMarker.setState(tieState);

                }
                countSimilar += 1;
            }
        }

        if (countSimilar>=2) {
            isTie = true;
            return 2;
        }else if (countSimilar ==1) {
            Winner = earMarker;
            return  1;
        }

        // reset the earmarker and count
        countSimilar =0;
        earMarker =null;
        //check for highest sequence ... check if a __tie
        System.out.println("checking for highest sequence sum in all the players");
         // REM :: zero sum is not considered as tie
        int checksum = 0;
        for (Player pie:
             Plyrs) {
            if (pie.highestSum_bySequence() !=0 && pie.highestSum_bySequence() > checksum){
                earMarker = pie; // the winner probably
                checksum= pie.highestSum_bySequence();
                countSimilar = 1;
            } else if(pie.highestSum_bySequence() !=0 && pie.highestSum_bySequence() == checksum){
                // this is a tie state
                earMarker.setState(tieState);
                countSimilar = 2;
                pie.setState(tieState);
            }
        }
        if (countSimilar>=2) {
            isTie = true;
            return 2;
        }else if (countSimilar == 1) {
            Winner = earMarker;
            return  1;
        }
        // reset the earmarker and count
        countSimilar =0;
        earMarker =null;
        //check for pair cards ... check if a __tie
        System.out.println("checking for pair states in all the players");
        for (Player pie:
                Plyrs) {
            if(pie.checkPairState()) {
                if (earMarker == null) {
                    earMarker = pie;
                } else {
                    // tie has occured
                    earMarker.setState(tieState);
                    //update the earmarker if any
                    earMarker = pie;
                    earMarker.setState(tieState);

                }
                countSimilar += 1;
            }
        }
        if (countSimilar>=2) {
            isTie = true;
            return 2;
        }else if (countSimilar ==1) {
            Winner = earMarker;
            return  1;
        }

        // reset the earmarker and count
        countSimilar =0;
        earMarker =null;

        // check for top card [ by value ] ... check if a __tie
        System.out.println("checking all players for top value card");
        for (Player pie:
                Plyrs) {
            int cmp = 0;
            if(pie.topCard_ByValue() > cmp){
                earMarker = pie;
                countSimilar =1;
            } else if (pie.topCard_ByValue() == cmp && earMarker != null){
                earMarker.setState(tieState);
                earMarker = pie;
                earMarker.setState(tieState);
                countSimilar =1;
            }
        }
        if (countSimilar>=2) {
            isTie = true;
            return 2;
        }else if (countSimilar ==1) {
            Winner = earMarker;
            return  1;
        }
        // --- continue the game stating it to be a no decider round
        System.out.println("continue to another step .. this is a no decider rounnd");
      return 0;
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
        System.out.println("Starting game play , is on round :"+ _isOn );
        // draw three cards for each player

        for (Player pie:
             copyPlayers) {
            pie.setCards(deck.draw3cards());
            pie.setState(gameState);

        }


        System.out.println("all the 4 players get the initial set of cards :: 3 each");
      // compare them to check tie / end state

        return checkPlayerStates(); // for testing purposes TODO
    }
    public int  step(){
        if(deck.deckSize()<=0){
            System.out.println("No more cards in game abort ... no winner !!!");
            System.exit(0);
        }
      _isOn +=1;
        System.out.println("Continue game to next round , is on round :"+ _isOn + "state : "+isTie );
      // all the players draw a new card
        // check for tied state and take actions
        if(isTie){
            //review the tied players
            _tiePlay = new ArrayList<>();
            for (Player P : Plyrs) {
                if (P.getState().toString().equalsIgnoreCase("Tie")) {
                    _tiePlay.add(P);
                    P.drawAnotherCard(deck.drawCard());
                }
            }


        }else {

            for (Player pie:
                    copyPlayers) {
                pie.drawAnotherCard(deck.drawCard());
            }
        }
        //for every step display the player deck
        for (Player pie:
             copyPlayers) {
            System.out.print("Player :" + pie.getName() + "Owns these cards in this round ");
            List<String> cardStack = pie.getCards();
            for (String card:
                 cardStack) {
                System.out.print(card + ",");
            }
            System.out.println();
        }
        // compare them to check tie / end state

        return checkPlayerStates();
    }
    public void end() {
        // set all the players to the end state Winner/Loser
        System.out.println("Wrapping off the game in round "+ _isOn + " with winner :: " + Winner.name);
        // emd state instances
        LoserState lostState = new LoserState();
        WinnerState winState = new WinnerState();
        for (Player pie:
             Plyrs) {
            if(pie.name.equalsIgnoreCase(Winner.name)){
                Winner.setState(winState);
            }else {
                pie.setState(lostState);
            }
        }
        //sanitize the tie state
        isTie = false;
        isEnded =true;
    }
 

 }