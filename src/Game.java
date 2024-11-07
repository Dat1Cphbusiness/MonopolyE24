import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
    private String name;
    private List<Player> players;
    private Player currentPlayer;
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

    public void setup() {
        ui.displayMsg("Welcome to " + this.name);
        ArrayList<String> data = io.readData(this.playerDataPath);

        if (!data.isEmpty()) {
            String continueGame = ui.promptText("Continue previously saved game? y/n");
            if (continueGame.equalsIgnoreCase("y")) {
                for (String s : data) {
                    String[] values = s.split(",");
                    String name = values[0];
                    int balance = Integer.parseInt(values[1].trim());
                    Player p = new Player(name, balance);
                    players.add(p);
                }
            } else if (continueGame.equalsIgnoreCase("n")) {
                registerPlayers();
            } else {
                System.out.println("Please enter a valid input y/n.");
                setup();
            }
        }
    }

    private void registerPlayers() {
        try {
            int playersPlaying = ui.promptNumeric("Enter amount of players(3 to 6): ");
            if (playersPlaying > 6 || playersPlaying < 3) {
                System.out.println("Please enter a valid number.");
                registerPlayers();
            } else {
                int counter = 0;
                while (counter < playersPlaying) {
                    String name = ui.promptText("Type name of player:");

                    Player p = new Player(name);
                    this.addPlayer(p);

                    counter++;
                }
                Collections.shuffle(players);
            }
        } catch (NumberFormatException nfe){
            System.out.println("Please enter a number.");
            registerPlayers();
        }
    }

    private void addPlayer(Player p) {
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

    public void runGameLoop(){
        int count = 0;
        boolean continueGame = true;
        while (continueGame) {
            currentPlayer = players.get(count);
            throwAndMove();
            continueGame = ui.promptBinary("Continue game? (Y/N)");
            count++;
            if (count == players.size()){
                count = 0;
            }
        }
    }

    public void endSession() {

        ArrayList<String> playersAsText = new ArrayList<>();
        for (Player p : players) {
            playersAsText.add(p.toString());
        }
        FileIO.saveData(playersAsText, this.playerDataPath, "name, balance");
    }

    public void throwAndMove(){
        System.out.println("Current player: " + this.currentPlayer);
    }

    public void landAndAct(){

    }
}
