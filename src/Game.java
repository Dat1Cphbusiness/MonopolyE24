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

    public void registerPlayers() {
        int playerNum = ui.promptNumeric("Type number of players: ");
        if (playerNum > 2 && playerNum < 7) {
            int i = 0;
            while (i< playerNum) {

                String name = ui.promptText("Type name of player:");
                int startAmount = ui.promptNumeric("Type start amount:");

                Player p = new Player(name, startAmount);
                this.addPlayer(p);
                ++i;
                }   // end while-loop
             }  else {
            System.out.println("Amount of players is out of range.\nRange is within 3-6 players\n************");
            registerPlayers();  //
        }

        ui.promptText("Number of players: " + players.size());
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

        for (Player c: players) {
            playerAsText.add(c.toString());
        }   // end for-each loop

        FileIO.saveData(playerAsText, this.playerDataPath, "name, balance");
    }   // end endSession()
}   // End Game
