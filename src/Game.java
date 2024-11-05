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

    public void addPlayers(Player c) {
        this.players.add(c);
    }

    public String toString() {
        String s = "";
        for (Player c : players) {
            s += c + "\n";
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

            Player c = new Player(name, startAmount);
            this.addPlayers(c);

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
                Player c = new Player(name, balance);
                players.add(c);
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

        ArrayList<String> customersAsText = new ArrayList<>();
        for (Player c : players) {
            customersAsText.add(c.toString());
        }
        FileIO.saveData(customersAsText, this.playerDataPath, "name, balance");
    }
}
