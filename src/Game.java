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
        this.playerDataPath="data/playerdata.csv";
    }
    public void addPlayer(Player c){
        this.players.add(c);
    }
    public String toString(){
        String s = "";
        for (Player c:players) {
            s+=c+"\n";
        }
        return s;
    }


    public List getPlayers() {
            return players;
    }

    public void registerPlayer() {

        String continueDialog = "Y";
        while (continueDialog.equalsIgnoreCase("Y")) {

            String name = ui.promptText("Type name of player:");
            int startAmount = ui.promptNumeric("Type start amount:");

            Player c = new Player(name, startAmount);
            this.addPlayer(c);

            continueDialog = ui.promptText("Do you wish to create another player?Y/N");

        }
    }
   public void setup(){
     ArrayList<String> data = io.readData(this.playerDataPath);

       if(!data.isEmpty()) {
           for (String s:data) {
               String[] values= s.split(",");
               String name = values[0];
               int balance = Integer.parseInt(values[1].trim());
               Player c = new Player(name, balance);
               players.add(c);
           }
       }
       else{
           registerPlayer();

       }

       }
   }
    public void endSession(){

        ArrayList<String> playersAsText = new ArrayList<>();
        for (Player c:players) {
            playersAsText.add(c.toString());
        }
        FileIO.saveData(playersAsText, this.playerDataPath, "name, balance");
    }
