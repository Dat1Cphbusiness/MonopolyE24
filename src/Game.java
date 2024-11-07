import java.util.ArrayList;
import java.util.List;

public class Game {
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
        this.playerDataPath ="data/playerdata.csv";
    }
    public void addPlayer(Player p){
        this.players.add(p);
    }
    public String toString(){
        String s = "";
        for (Player p: players) {
            s+=p+"\n";
        }
        return s;
    }


    public List getPlayers() {
            return players;
    }

    public void registerPlayers() {
        int playerNum = ui.promptNumeric("Type Number Of Players");
        if (playerNum < 2 || playerNum > 6){
            ui.displayMsg("The Number Of Players Must Be 2, 3, 4, 5 Or 6");
            registerPlayers();
        }
        int startAmount = ui.promptNumeric("Type start amount:");
        //String continueDialog = "Y";
        while (players.size() < playerNum) {

            String name = ui.promptText("Type name of player " + (players.size() + 1) + ": ");

            Player p = new Player(name, startAmount);
            this.addPlayer(p);
            //continueDialog = ui.promptText("Do you wish to create another player? Y/N");

        }
    }
   public void setup(){
    ui.displayMsg("Velkommen til " + this.name);
     ArrayList<String> data = io.readData(this.playerDataPath);

       if(!data.isEmpty() && ui.promptText("Continue previously saved game? y/n").equalsIgnoreCase("y")) {
           for (String s:data) {
               String[] values= s.split(",");
               String name = values[0];
               int balance = Integer.parseInt(values[1].trim());
               Player p = new Player(name, balance);
               players.add(p);
           }
       }
       else{
           registerPlayers();
       }
   }
    public void endSession(){

        ArrayList<String> playersAsText = new ArrayList<>();
        for (Player p: players) {
            playersAsText.add(p.toString());
        }
        FileIO.saveData(playersAsText, this.playerDataPath, "name, balance");
    }

}
