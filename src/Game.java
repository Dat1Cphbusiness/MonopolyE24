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
        for (Player c: players) {
            s+=c+"\n";
        }
        return s;
    }


    public List getPlayer() {
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
   public void loadData(){
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
   }
    public void endSession(){

        ArrayList<String> playerAsText = new ArrayList<>();
        for (Player c: players) {
            playerAsText.add(c.toString());
        }
        FileIO.saveData(playerAsText, this.playerDataPath, "name, balance");
    }

}
