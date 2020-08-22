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
    // start the game play and verify if win is achieved in round 1

    if (context.start() == 1){
      context.end();
    } else {
      while (context.step() != 1) ; // step until game winner is decided
      context.end(); // sanitize the game play
    }

  }
}
