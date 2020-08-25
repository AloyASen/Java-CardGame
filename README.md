# JAVA CARD GAME LIFECYCLE [ USING GRADLE] 

### Problem statement
```
The festival season is here and we realize it's hard to play
all those complicated card games, when drunk !!! 
We decided to make a simple luck based game for people top play 
when they have limited motor and sensory control. hang tight !!!

Basic rules
- use a standard deck of cards (no joker)
- 'A' is considered to have a number value of 1 
- 'A' is considered the top card in a face-off. so the order is 
A>K>Q>J>10...2

Victory 
+ A trail [Three cards of the same number] is the 
highest possible combination
+ the next highest is a sequence (numbers in a order
eg., 4,5,6. A is consideredc to have tohe value of 1 )
+ The next highest is a pair of cards ( two kings or two 10's )
+ if all else fails the top card by nuber value wins)
+ If there is a tie, each tied player draws a single card from the deck untill the
winner is found 
+ onky the newly drawn cards are compared to decide a tie
The top card ( by victory sequencing ) wins a tie.
+ for now the suit ( spade / hearts ) does not matter .  

```

### The gameplan demonstrated here 

+ Simulate a game between four players
+ Randomly deal them cards from a deck.
+ determine the winner.

### What are we interested in
+ Usage of core libraries
+ Display of testing using JUnit
+ Game Library design using design patterns 
+ Implementation of game lifecycles.
+ Probe able game states (for better debugging )
+ Plugable and extensible architecture with multi gradle architecture.
+ Secure game deck with overflow locking.
+ usage of Protected, private and public functors , to properly manage scope.

# What should you expect from this project
Solving a library Design problem for a card game
The silos game of TeenPaatti ... here we call the main() 
![cardGame.Java](https://github.com/AloyASen/Java-CardGame/blob/master/codeMap/cardGame.png)
the Main Creates the game instance ```Lifecycle Design pattern```
![SimpleCardGame.Java](https://github.com/AloyASen/Java-CardGame/blob/master/codeMap/simple_card_game_java.png)
The players are botched up dynamically 
![player.Java](https://github.com/AloyASen/Java-CardGame/blob/master/codeMap/Player_Java.png)
The Game Deck is shuuffled random once, securely ... securities applied
![GameDeck.Java](https://github.com/AloyASen/Java-CardGame/blob/master/codeMap/gameDeck_java.png)
The Players maintain individual states ```State Design pattern```
![State.Java](https://github.com/AloyASen/Java-CardGame/blob/master/codeMap/state_java.png)
# Building this Projects with Gradle

##### This guide walks you through using Gradle to build a simple Java project.

### What you’ll need
+ A favorite text editor or IDE
+ JDK 8 or later
+ Install Gradle 4.8 and later

### Install Gradle
+ **On Unix**

```
$ sudo add-apt-repository ppa:cwchien/gradle
$ sudo apt-get update
$ sudo apt-get install gradle
```


+ **On Mac OS X**
    + `brew install gradle`

    + [Install Homebrew](http://brew.sh/).


+ **On Windows**

  + [Download from Gradle site](https://docs.gradle.org/current/userguide/installation.html).

  + Unzip the Gradle download to the folder to which you would like to install Gradle, eg. “C:\Program Files”. The subdirectory gradle-x.x will be created from the archive, where x.x is the version.

  + Add location of your Gradle “bin” folder to your path. Open the system properties (WinKey + Pause), select the “Advanced” tab, and the “Environment Variables” button, then add “C:\Program Files\gradle-x.x\bin” (or wherever you unzipped Gradle) to the end of your “Path” variable under System Properties. Be sure to omit any quotation marks around the path even if it contains spaces. Also make sure you separated from previous PATH entries with a semicolon “;”.

  + In the same dialog, make sure that JAVA_HOME exists in your user variables or in the system variables and it is set to the location of your JDK, e.g. C:\Program Files\Java\jdk1.7.0_06 and that %JAVA_HOME%\bin is in your Path environment variable.

  + Open a new command prompt (type cmd in Start menu) and run gradle –version to verify that it is correctly installed.
  
### To test the Gradle installation, run Gradle from the command-line: `gradle`
+ If all goes well, you see a welcome message:
```
:help

Welcome to Gradle 2.8.

To run a build, run gradle <task> ...

To see a list of available tasks, run gradle tasks

To see a list of command-line options, run gradle --help

To see more detail about a task, run gradle help --task <task>

BUILD SUCCESSFUL

Total time: 6.317 secs
```

+  You now have Gradle installed.

#### Find out what Gradle can do
Now that Gradle is installed, see what it can do. Before you even create a build.gradle file for the project.

   + You can ask it what tasks are available: `gradle tasks`

   + If you run `gradle tasks` this command out side your project directory then you can see the output.

```
:tasks
------------------------------------------------------------
All tasks runnable from root project
------------------------------------------------------------

Build Setup tasks
-----------------
init - Initializes a new Gradle build. [incubating]
wrapper - Generates Gradle wrapper files. [incubating]

Help tasks
----------
components - Displays the components produced by root project 'jabed'. [incubating]
dependencies - Displays all dependencies declared in root project 'jabed'.
dependencyInsight - Displays the insight into a specific dependency in root project 'jabed'.
help - Displays a help message.
model - Displays the configuration model of root project 'jabed'. [incubating]
projects - Displays the sub-projects of root project 'jabed'.
properties - Displays the properties of root project 'jabed'.
tasks - Displays the tasks runnable from root project 'jabed'.

To see all tasks and more detail, run gradle tasks --all

To see more detail about a task, run gradle help --task <task>

BUILD SUCCESSFUL

Total time: 2.435 secs
```



### Build this code

Now we are behind few step.

+ `cd <PROJECT_FOLDER>` 

+ Now Run this command `gradle build`.

    To see the results of the build effort, take a look in the build folder. Therein you’ll find several directories, including these three notable folders:

    + classes. The project’s compiled .class files.
    + libs. Assembled project libraries (JAR  files).


+ To make this code runnable [ production ready ], OpenLib  uses gradle’s application plugin. Add this to your `build.gradle` file.Now Open `build.gradle` file and add this two line
 ```
apply plugin: 'application'
mainClassName = 'hello.HelloWorld'
```

+ We are almost done just run this command `gradle run`.
  Now you can see the output

```
  :compileJava UP-TO-DATE
  :processResources UP-TO-DATE
  :classes UP-TO-DATE
  :run

  Hello!
  Initializing the players and the deck
  ...

  BUILD SUCCESSFUL
  Total time: 4.009 secs
```

Yes we have done .... :)


Now if you run `gradle build`, Gradle should resolve the Joda Time dependency from the Maven Central repository and the build will succeed.

+ Other build issues can occur due to differences in the Version used in development and production. Please
Handle it according to the logging provided by `gradle build`.

### Build this project with Gradle Wrapper

+ The Gradle Wrapper is the preferred way of starting a Gradle build.
    - It consists of a batch script for Windows.
    - and a shell script for OS X and Linux.

+ These scripts allow you to run a Gradle build without requiring that Gradle be installed on your system.

+ To make this possible, add the following block to the bottom of your `build.gradle`.

```
  task wrapper(type: Wrapper) {
      gradleVersion = '2.8'
  }
```

+ Run the following command to download and initialize the wrapper scripts: `gradle wrapper`.

+ After this task completes, you will notice a few new files. The two scripts are in the root of the folder, while the wrapper jar and properties files have been added to a new `gradle/wrapper` folder.

```
    └── src
    └── gradlew
    └── gradlew.bat
    └── gradle
        └── wrapper
            └── gradle-wrapper.jar
            └── gradle-wrapper.properties
```
    
+ The Gradle Wrapper is now available for building your project.

+ Add it to your version control system, and everyone that clones your project can build it just the same. It can be used in the exact same way as an installed version of Gradle. Run the wrapper script to perform the build task, just like you did previously: `./gradlew build`

+ The first time you run the wrapper for a specified version of Gradle, it downloads and caches the Gradle binaries for that version. The Gradle Wrapper files are designed to be committed to source control so that anyone can build the project without having to first install and configure a specific version of Gradle.

+ At this stage, you will have built your code. You can see the results here:

```
  build
  ├── classes
  │   └── main
  │       └── hello
  │           ├── Greeter.class
  │           └── HelloWorld.class
  ├── dependency-cache
  ├── libs
  │   └── hello-world-gradle-0.1.0.jar
  └── tmp
      └── jar
          └── MANIFEST.MF
```

+ Included are the two expected class files for Greeter and HelloWorld, as well as a JAR file. Take a quick peek:

```
  $ jar tvf build/libs/hello-world-gradle-0.1.0.jar
  0 Mon Nov 16 13:41:22 BDT 2015 META-INF/
    25 Mon Nov 16 13:41:22 BDT 2015 META-INF/MANIFEST.MF
     0 Mon Nov 16 13:41:22 BDT 2015 hello/
   988 Mon Nov 16 13:41:22 BDT 2015 hello/cardGame.class
   ...
```

+ NOTE :: The gradle wrapper might need to be upgraded

according to the requirements of the production build

#### To manage the gmaeplay 

+ Dial the knobs of the random seed in ```./src/main/java/hello/Deck.java```

```
...
private void shuffle() {
        // shuffle the deck
        Collections.shuffle(Cards, new Random(<SEED HERE>));
        System.out.println("the shuffled initial deck size of cards: " + deckSize());
        for (String card:
             Cards) {
            System.out.print(" "+ card);
        }
        System.out.println(" is the list of cards in the shuffled deck");  
}
...

``` 

##### There are bugs that need to be probed detected and handled ... I don't intend it for production, though this code is quite production ready. 