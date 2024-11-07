import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
    private String name;
    private List<Player> players;
    private TextUI ui;
    private FileIO io;
    private String playerDataPath;
    private String currentPlayer;


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
        int playerNum = ui.promptNumeric("Type numbers of players: ");
        if (playerNum < 2 || playerNum > 6) {
            registerPlayers();
            return;
        }

        while (playerNum != 0) {

            String name = ui.promptText("Type name of player:");
            int startAmount = ui.promptNumeric("Type start amount:");

            Player p = new Player(name, startAmount);
            this.addPlayer(p);
            playerNum--;
        }
        Collections.shuffle(this.players);

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

    public void runGameLoop(){
        if(!players.isEmpty()) {
            currentPlayer = players.get(0).getName();
            ui.displayMsg("Det er " + currentPlayer + "'s tur.");
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