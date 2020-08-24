package hello;

import java.util.*;

public class Deck{
     private List<String> Cards = new ArrayList<>(); // will be 52 cards initially
    List<String> suit = new ArrayList<>();
    //all the rank cards in the game A is considered top card
    String[] ranks= {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public Deck() {
        super(); // currently unused TODO
        suit.add("Spades");
        suit.add("Hearts");
        suit.add("Diamonds");
        suit.add("clubs");
    }
    private void shuffle() {
        // shuffle the deck
        Collections.shuffle(Cards, new Random(3));
        System.out.println("the shuffled initial deck size of cards: " + deckSize());
        for (String card:
             Cards) {
            System.out.print(" "+ card);
        }
        System.out.println(" is the list of cards in the shuffled deck");
    }
    public void init() {
        ListIterator<String> groups= suit.listIterator();
        // for all the groups the rank cards are to be added
        while (groups.hasNext()){
            System.out.println(" group indexing ranks for :: "+ groups.next());
            for (String rank:
            ranks) {
              Cards.add(rank);
            }
        }
        // now shuffle the cards
        shuffle();
    }
    // what is the current deck size 
    public int deckSize() {

        return Cards.size();
    }
    // get the three player cards 
    public List<String> draw3cards() {
        List<String> hand = new ArrayList<>();
        hand.add(drawCard());
        hand.add(drawCard());
        hand.add(drawCard());
        System.out.println("three shuffled cards added to hand");
        return hand;
    }
    public String drawCard() {
        // get the top  card and delete it from the list of 'shuffled cards'
        String card;
        if(deckSize()>0){
            card = Cards.get(0);
            Cards.remove(0);
            System.out.println("New card drawn from the pile::" + card);
            return card;
        }else {
            System.out.println("ISSUE:: no more card in pile" );
            System.exit(0);
            return null;
        }
    }
}