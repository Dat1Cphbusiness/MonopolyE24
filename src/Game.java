import java.util.ArrayList;

public class Game {
 private String name;
 private ArrayList<Player> players;
 private ArrayList<String> listOfActions;
 private TextUI ui = new TextUI();;
 private FileIO io = new FileIO();
 private String playerDataPath = "data/playerData.csv";




    private Player currentPlayer;

    public Game(String name){
        this.name = name;
        players = new ArrayList<>();
        listOfActions = new ArrayList<>();
        listOfActions.add("1) start new game");
        listOfActions.add("2) continue game");
        listOfActions.add("3) quit game");

    }
    public void createPlayer(String name, int balance){
        if(name == null) {
            name = ui.promptText("Spillerens navn: ");
        }
        currentPlayer =  new Player(name, balance);
        this.players.add(currentPlayer);
    }
    public void runDialog(){
        ui.displayMsg("Velkommen til "+this.name);
        int action = 0;

        while(action != listOfActions.size()){// the quit action is the last action
         action = ui.promptChoice(listOfActions, "Vælg en af følgende:");

         switch(action){
             case 1:
                 //start new game

                    this.registerPlayers();
                    this.runGameLoop();
                  break;
              case 2:
                  // Continue game
                  displayPlayers();
                  this.loadPlayerData();
                  this.runGameLoop();
                  break;

         }
        // Main.saveData(this.players);
        }




    }

    private void loadPlayerData() {
        ArrayList<String> data = io.readPlayerData(playerDataPath);  //"Tess, 2000"

        if(data.size()>0){
            for (String s:data) {
                String[] values = s.split(",");//"Tess, 2000" == ["Tess", " 2000"]
                int balance = Integer.parseInt(values[1].trim());
                 String name = values[0];
                 createPlayer(name, balance);
            }

        }else{
            registerPlayers();
        }
    }

    private void registerPlayers() {
        players = new ArrayList<>();//reset players array
        while(this.players.size()<6){
            createPlayer(null,0);
        }
    }

    public void displayPlayers(){
 for(Player c: players){
        System.out.println(c);
    }
}
 private void runGameLoop(){
        int count = 0;
        String input = "Y";
        while(input.equalsIgnoreCase("Y")){
            currentPlayer = players.get(count);
            ui.displayMsg("Det er "+currentPlayer.getName()+"'s tur");
            //throwAndMove()
            input = ui.promptText("Fortsæt? Y/N: ");
            count++;
            if(count == players.size()){
                count = 0;
            }
        }

 }

}
