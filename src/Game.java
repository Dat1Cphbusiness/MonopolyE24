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
    private Dice dice;
    Board board;
    private int startAmount = 30000;
    int count = 0;
    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.ui = new TextUI();
        this.io = new FileIO();
        this.playerDataPath ="data/playerdata.csv";
        this.dice = new Dice();
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


    public List<Player> getPlayers() {
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
          //  int startAmount = ui.promptNumeric("Type start amount:");
            Player p = new Player(name, this.startAmount);
            this.addPlayer(p);
        }
        Collections.shuffle(players);
    }

    public void setupBoard() {
        String[] carddata =  io.readBoardData("data/carddata.csv", 38);
        String[] fielddata = io.readBoardData("data/fielddata.csv", 40);
        board = new Board(fielddata, carddata);
        System.out.println(board.getField(40));
        System.out.println(Board.cardDeck.getNext());
    }
   public void setupPlayers(){
    ui.displayMsg("Welcome to " + this.name); 
     ArrayList<String> data = io.readPlayerData(this.playerDataPath);

       if(!data.isEmpty() && ui.promptBinary("Do you want to continue the game? y/n")) {
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

     setupBoard();

   }

    public void runGameLoop(){

        boolean continueGame = true;
        while(continueGame && players.size()>1){

            currentPlayer = players.get(count);
            throwAndMove();
            if( currentPlayer.isBankrupt()){
                this.removePlayer(currentPlayer);
                //fjern fra listen
            }
            continueGame = ui.promptBinary("Continue game? Y/N");
            if(count == players.size()-1) {
                count = 0;
            }
            else {
                count++;
            }

        }
    }
    int counter = 0;
   public void throwAndMove(){
       int result;
       ui.displayMsg("It's now " + currentPlayer.getName() + "'s turn");
       if (currentPlayer.getDestination() > 0){
           result = currentPlayer.getDestination();
       } else {
           result = 2;//dice.rollDiceSum();

       }
        ui.displayMsg(currentPlayer.getName() + " slog " + result);
        int newPosition = currentPlayer.updatePosition(result);
        Field f = board.getField(newPosition);

        if(dice.isDouble){
            counter++;
            ui.displayMsg("You get another turn, thank double dice");
            if(counter != 3){

                landAndAct(f);
                count--;//samme spiller vil blive sat til currentPlayer igen, når vi rammer runGameLoop
                //throwAndMove();//udkommenteret fordi vi skal have runGameLoop med, hvor der er et tjek på om spilleren stadig er "levende"

            }
            else {
                currentPlayer.moveToPrison();
                counter = 0;
                ui.displayMsg(currentPlayer.getName() + " has been sent to prison");
            }
        }else {
            landAndAct(f);
        }


   }

   public void landAndAct(Field f){
        String msg = f.onLand(currentPlayer); //Egon er landet på valbylanggade



        if(f.getOption() != null) {
            boolean response = ui.promptBinary(msg);
           msg = f.processResponse(currentPlayer, response);//Egon har købt valbylangggade
        }

       ui.displayMsg(msg);


   }


    public void endGame(){
        ui.displayMsg("Game is ending");

        ArrayList<String> playersAsText = new ArrayList<>();
        for (Player p: players) {
            playersAsText.add(p.toString());
        }
        FileIO.saveData(playersAsText, this.playerDataPath, "name, balance");
    }
    public void removePlayer(Player p) {
        players.remove(p);
    }

}
