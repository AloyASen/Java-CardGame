package hello;


import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// each player has a state of activity
public class Player extends PointsMap {
    // the state of the game Play
    private State state;
    // the player name 
    public String  name;
    // the list of the cards drawn by the user
    public Player(String name) {
       super();
       //set the player name
        this.name = name;
       // initialize the player as   NEW state 
      this. state = new NewPlayer() ;
    }
    List<String> cards;
    // calculate the score from the cards
    public int calculateScore(){
        System.out.println("calculating the score for player ::"+ this.name);
        getCards();
        return 0;
    }
    // check if trieState of cards appear
    public boolean checkTriState(){
        System.out.println("Checking the trie State for player ::"+ this.name);
        int checker = 2;
        int temp = 0;
        for ( String card: cards){
            for (String s : cards) {
                if (card.equals(s)) {
                    temp += 1;
                }
            }
            // if checker satisfied then return
            if(temp >= checker) return true; // HOLA a trie state found
        }
        return false; // all cards are checked and no trie state
    }
    // check if pair State of cards appear
    public boolean checkPairState(){
        System.out.println("Checking the trie State for player ::"+ this.name);
        int checker = 1;
        int temp = 0;
        for ( String card: cards){
            ListIterator itr = cards.listIterator();
            while (itr.hasNext()){
                if(card.equals(itr.next())){
                    temp +=1;
                }
            }
            // if checker satisfied then return
            if(temp >= checker) return true; // HOLA a pair state found
        }
        return false; // all cards are checked and no trie state
    }
    public int topCard_ByValue(){
        int value=0;
        for (String card:
             cards) {
            if (pointsTable.get(card) >=value){
                value= pointsTable.get(card);
            }
        }
        return value;
    }
    public int highestSum_bySequence(){
        int sequenceValue =0;
        // this is responsible for synchromization of sequence checks in
        boolean previousInSync = Boolean.parseBoolean(null);
        //order the cards in ascending
        Collections.sort(cards);
        // determine sequence height and static sum consequently
        // use a list iterator for this purpose
        for (int i = 0; i < cards.size() ; i++) {
            if( previousInSync && i>0){
                // look back and compare the points
                if (pointsTable.get(cards.get(i)) - pointsTable.get(cards.get(i-1)) == 1){
                    previousInSync =true;
                    sequenceValue += pointsTable.get(cards.get(i));
                } else {
                    // sequence breached ... flush it
                    sequenceValue =0;
                }
            }else if( i==0) {
                previousInSync =true; //since no data is available
                sequenceValue += pointsTable.get(cards.get(i));
            }else {
                //checksum for the default states
                previousInSync = false;
                sequenceValue = 0;
            }
        }
        return sequenceValue;
    }
    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public void setState(State state){
        this.state = state;		
     }
    public State getState(){
        return state;
     }

    public int drawAnotherCard(String card){
        cards.add(card);
        return 1; // status check sum TODO
    }
}