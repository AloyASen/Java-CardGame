package hello;

import java.util.ArrayList;
import java.util.List;

public class Deck{
     private String[] Cards ; // will be 52 cards initially
    List<String> suit = new ArrayList<>();
    //all the rank cards in the game A is considered top card
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public Deck() {
        super(); // currently unused TODO
        suit.add("Spades");
        suit.add("Hearts");
        suit.add("Diamonds");
        suit.add("clubs");
    }
    private void shuffle() {
        // shuffle the deck 
    }
    public void init() {
        
    }
    // what is the current deck size 
    public int deckSize() {

        return 0;
    }
    // get the three player cards 
    public List<String> draw3cards() {
        List<String> hand = null;
        hand.add(drawCard());
        hand.add(drawCard());
        hand.add(drawCard());
        return hand;
    }
    public String drawCard() {
        // get a card and delete it from the list of 'shuffled cards'
        return null;
    }
}