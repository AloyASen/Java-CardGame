package hello;

import java.util.List;

public class Deck{
     private List Cards = [] // will be 52 cards initially
    List suit = ['S', 'H', 'D', 'C'];
    List rank = [ '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A' ]
    public Deck() {
        super(); // currently unused TODO
    }
    private void shuffle() {
        // shuffle the deck 
    }
    public void init() {
        
    }
    // what is the current deck size 
    public int deckSize() {
        
    }
    // get the three player cards 
    public List draw3cards() {
        List hand = [];
        hand.addCard(drawCard());
        hand.addCard(drawCard());
        hand.addCard(drawCard());
        return hand;
    }
    public String drawCard() {
        // get a card and delete it from the list of 'shuffled cards'
    }
}