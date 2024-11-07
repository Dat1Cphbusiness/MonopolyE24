import java.util.ArrayList;
import java.util.List;

public class Game {
    // Attributes
    private String name;
    private List<Player> players;
    private TextUI ui;
    private FileIO io;
    private String playerDataPath;
    private Player currentPlayer;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.ui = new TextUI();
        this.io = new FileIO();
        this.playerDataPath="data/playerdata.csv";
    }   // end Constructor

    public Player getCurrentPlayer() {
        return currentPlayer;
    }   // end getCurrentPlayer()

    public String getCurrentPlayerName() {
        return getCurrentPlayer().getName();
    }   // end getCurrentPlayerName()

    public void addPlayer(Player p){
        this.players.add(p);
    }   // end addPlayer()

    @Override
    public String toString(){
        String str = "";

        for (Player p: players) {
            str += p + "\n";
        }   // end for-each loop

        return str;
    }   // end toString()

    public List getPlayers() {
            return this.players;
    }   // end getPlayers()

    public Player getPlayerByIndex(int index) {
        Player p;
        try {
            p = this.players.get(index);    // returns the player by the userInput

        } catch  (IndexOutOfBoundsException e) {
            p = this.players.get(0);        // if
        }   // end try-catch statement
        return p;
    }   // end getPlayerByIndex()

    public void registerPlayers() {
        int playerNum = ui.promptNumeric("Enter number of players: ");
        if (playerNum > 2 && playerNum < 7) {
            int i = 1;
            while (i <= playerNum) {

                String name = ui.promptText("Type name of player:");
                int startAmount = ui.promptNumeric("Type start amount:");

                Player p = new Player(name, startAmount);
                this.addPlayer(p);
                ++i;
                }   // end while-loop
             }  else    {

            System.out.println("Amount of players is out of range.\nRange is 3-6 players\n************");
            registerPlayers();  //  recursion
        }   // end if-else statement

        ui.displayMsg("Number of players: " + players.size());      // prints amount of players registered based on the
    }   // end registerPlayer()

   public void setup(){
     ui.displayMsg("Velkommen til Matador, " + this.name);
     ArrayList<String> data = io.readData(this.playerDataPath);

       if(!data.isEmpty() && ui.promptText("Continue previously saved gamed? Y/N").equalsIgnoreCase("Y")) {
           for (String str  :  data) {
               String[] values= str.split(",");
               String name = values[0];
               int balance = Integer.parseInt(values[1].trim());
               Player p = new Player(name, balance);
               players.add(p);
           }    // end for-each loop
       }  else {
           registerPlayers();
       }    // end if-else statement
   }    // end loadData()

    public void endSession(){
        ArrayList<String> playerAsText = new ArrayList<>();

        for (Player p: players) {
            playerAsText.add(p.toString());
        }   // end for-each loop

        FileIO.saveData(playerAsText, this.playerDataPath, "name, balance");
    }   // end endSession

    public void runGameLoop(){
        int count = 0;
        boolean continueGame = true;
        while (continueGame) {
            currentPlayer = players.get(count);
            throwAndMove();
            continueGame = ui.promptBinary("Would you like to play again? (y/n)");
        }   // end while-loop

        players.set(0, this.currentPlayer);
        System.out.println(players.get(1));
    }   // end runGameLoop()

    public int throwAndMove(){
        int dice1 = rollDice();                     // get a new random int
        int dice2 = rollDice();                     // get a new random int
        int totalDiceEyes = dice1 + dice2;

        ui.displayMsg("You have rolled: " + dice1 +" + " + dice2 + " = " + totalDiceEyes);   // calling displayMsg from our TextUI class & typecasting totalDiceEyes
        return totalDiceEyes;
    }   // end throwAndMove()

    public void landAndAct(){
        int count = 0;
    }   // end landAndAct

    public int rollDice() {
        int result = (int) (Math.random() * 6) + 1;

        while (result > 6) {
            result = (int) (Math.random() * 6) + 1;
        }   // end while-loop

        return result;  // returns a number between 1 and 6
    }   // end rollDice()

}   // End Game
