package hello;


public class cardGame {
  public static void main(String[] args) {
    
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());


    // create the four players for the game 
    Player suraj = new Player("suraj");
    Player preetam = new Player("preetam");
    Player soumya = new Player("soumya");
    Player avinash = new Player("avinash");

    // Make the game Context of the game

    SimpleCardGame context = new SimpleCardGame(suraj, preetam, soumya, avinash);

  }
}
