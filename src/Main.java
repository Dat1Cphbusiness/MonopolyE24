import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet{
   static ArrayList<Game> games = new ArrayList<>();
   public void setup(){

       Game game = new Game("Monopoly", this);
       games.add(game);
       game.runDialog();
   }
    public static void main(String[] args) {

        String[] appletArgs = new String[]{"Main"};
        PApplet.main(appletArgs);



    }
    public void settings() {
        size(760, 900);
    }

}

