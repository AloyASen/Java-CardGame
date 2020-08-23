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
    // calculate the winners
    // check if trieState of cards appear
    public boolean checkTriState(){
        System.out.println("Checking the trie State for player ::"+ this.name);
        int checker = 2;
        int temp = 0;
        ListIterator iterator1 = cards.listIterator();
        ListIterator iterator2 = cards.listIterator();
        while ( iterator1.hasNext()){
            while ( iterator2.hasNext()) {
                if (iterator1.next().equals(iterator2.next()) && iterator1.nextIndex() != iterator2.nextIndex()) {
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
        ListIterator iterator1 = cards.listIterator();
        ListIterator iterator2 = cards.listIterator();
        while ( iterator1.hasNext()){
            while ( iterator2.hasNext()) {
                if (iterator1.next().equals(iterator2.next()) && iterator1.nextIndex() != iterator2.nextIndex()) {
                    temp += 1;
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
        //order the cards in ascending ... according to points
        Collections.sort(cards, new SortByPoints());
        // determine sequence height and static sum consequently
        // use a list iterator for this purpose
        for (int i = 0; i < cards.size() ; i++) {
            if( i>0){
                // look back and compare the points
                if (pointsTable.get(cards.get(i)) - pointsTable.get(cards.get(i-1)) == 1){
                    if(previousInSync == true) {
                        sequenceValue += pointsTable.get(cards.get(i));
                        previousInSync =true;
                    }
                    else {
                        sequenceValue = 0;
                        sequenceValue += pointsTable.get(cards.get(i));
                        previousInSync = true;
                    }
                } else {
                    // sequence breached ... flush it
                    sequenceValue =0;
                    sequenceValue += pointsTable.get(cards.get(i));
                    previousInSync = false;
                }
            }
            // special start state only
            if( i==0) {
                previousInSync =true; //since no data is available
                sequenceValue += pointsTable.get(cards.get(i));
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
    public String getName() {
        return name;
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