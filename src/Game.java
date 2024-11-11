import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
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
        int playerNum = ui.promptNumeric("Type number of players.");
        if (playerNum < 2 || playerNum > 6){
            ui.displayMsg("The number must be between 2 and 6 incl.");
            registerPlayers();
            return;
        }
        while (players.size() < playerNum) {
            String name = ui.promptText("Type name of player " + (players.size()+1) + ":");
            int startAmount = ui.promptNumeric("Type start amount:");
            Player p = new Player(name, startAmount);
            this.addPlayer(p);
        }
        Collections.shuffle(players);
    }
   public void setup(){
    ui.displayMsg("Velkommen til " + this.name);
     ArrayList<String> data = io.readPlayerData(this.playerDataPath);

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
       String [] carddata = io.readBoardData("data/carddata.csv", 100);
       String [] fielddata = io.readBoardData("data/carddata.csv", 40);

       System.out.println("test af fielddata" + fielddata);
       System.out.println("test af carddata" + carddata);
   }

   public void runGameLoop(){
        currentPlayer = players.get(0);
        ui.displayMsg("It's now " + currentPlayer.getName() + "'s turn");
   }
    public void endSession(){

        ArrayList<String> playersAsText = new ArrayList<>();
        for (Player p: players) {
            playersAsText.add(p.toString());
        }
        FileIO.saveData(playersAsText, this.playerDataPath, "name, balance");
    }

}
