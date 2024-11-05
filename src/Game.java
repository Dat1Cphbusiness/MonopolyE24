import java.util.ArrayList;
import java.util.List;

public class Game {
    // Attributes
    private String name;
    private List<Player> players;
    private TextUI ui;
    private FileIO io;
    private String playerDataPath;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.ui = new TextUI();
        this.io = new FileIO();
        this.playerDataPath="data/playerdata.csv";
    }   // end Constructor

    public void addPlayer(Player c){
        this.players.add(c);
    }   // end addPlayer()

    public String toString(){
        String str = "";
        for (Player c: players) {
            str+=c+"\n";
        }   // end for-each loop
        return str;
    }   // end toString()


    public List getPlayers() {
            return players;
    }   // end getPlayers()

    public void registerPlayer() {
        String continueDialog = "Y";
        while (continueDialog.equalsIgnoreCase("Y")) {

            String name = ui.promptText("Type name of player:");
            int startAmount = ui.promptNumeric("Type start amount:");

            Player c = new Player(name, startAmount);
            this.addPlayer(c);

            continueDialog = ui.promptText("Do you wish to create another player?Y/N");
        }   // end while-loop
    }   // end registerPlayer()

   public void loadData(){
     ArrayList<String> data = io.readData(this.playerDataPath);

       if(!data.isEmpty()) {
           for (String str  :  data) {
               String[] values= str.split(",");
               String name = values[0];
               int balance = Integer.parseInt(values[1].trim());
               Player c = new Player(name, balance);
               players.add(c);
           }    // end for-each loop
       }    // end if-statement
   }    // end loadData()

    public void endSession(){
        ArrayList<String> playerAsText = new ArrayList<>();

        for (Player c: players) {
            playerAsText.add(c.toString());
        }   // end for-each loop

        FileIO.saveData(playerAsText, this.playerDataPath, "name, balance");
    }   // end endSession
}   // End Bank
