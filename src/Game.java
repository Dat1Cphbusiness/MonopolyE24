import org.w3c.dom.Text;

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
        this.playerDataPath = "data/playerdata.csv";
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public String toString() {
        String s = "";
        for (Player p : players) {
            s += p + "\n";
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

            Player p = new Player(name, startAmount);
            this.addPlayer(p);

            continueDialog = ui.promptText("Do you wish to create another player?Y/N");

        }
    }

    public void setup() {
        ArrayList<String> data = io.readData(this.playerDataPath);

        if (!data.isEmpty() && ui.promptText("Continue previously saved game? Y/N").equalsIgnoreCase("Y")) {
            for (String s : data) {
                String[] values = s.split(",");
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                Player p = new Player(name, balance);
                players.add(p);
            }
        } else {
            registerPlayer();
        }
    }


        public void endSession(){

            ArrayList<String> playersAsText = new ArrayList<>();
            for (Player p : players) {
                playersAsText.add(p.toString());
            }
            FileIO.saveData(playersAsText, this.playerDataPath, "name, balance");
        }
    }
