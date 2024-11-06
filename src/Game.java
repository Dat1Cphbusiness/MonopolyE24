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

    public void addPlayers(Player p) {
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

    public void registerPlayers() {

        String continueDialog = "Y";
        while (continueDialog.equalsIgnoreCase("Y")) {

            String name = ui.promptText("Type name of customer:");
            int startAmount = ui.promptNumeric("Type start amount:");

            Player p = new Player(name, startAmount);
            this.addPlayers(p);

            continueDialog = ui.promptText("Do you wish to create another customer?Y/N");

        }
    }

    public void setup() {
        ArrayList<String> data = io.readData(this.playerDataPath);
        ui.displayMsg("Welcome to " + this.name);

        if (!data.isEmpty() && ui.promptText("Continue previously saved game? Y/N").equalsIgnoreCase("Y")) {
            // Continue with saved game
            for (String s : data) {
                String[] values = s.split(",");
                String name = values[0];
                int balance = Integer.parseInt(values[1].trim());
                Player p = new Player(name, balance);
                players.add(p);
            }
        } else if ((data.isEmpty() && ui.promptText("Continue previously saved game? Y/N").equalsIgnoreCase("N"))) {
            ui.displayMsg("No game found");
            registerPlayers();

        } else {
            ui.displayMsg("Invalid input - Must be either Y or N");
            setup();

        }
    }


    public void endSession() {

        ArrayList<String> playerAsText = new ArrayList<>();
        for (Player p : players) {
            playerAsText.add(p.toString());
        }
        FileIO.saveData(playerAsText, this.playerDataPath, "name, balance");
    }
}
