import java.util.ArrayList;
/*
*
TODO: Man modtager plot selvom man ikke har råd (der er noget med pay og buyProperty).
TODO: Hvis man svarer noget forkert, så crasher programmet grundet rekursivt kald i processResponse.
TODO: Jail er ikke implementeret.
updatePosition tager ikke højde for at man kan rykke 3 felter tilbage, og skal tildele penge (4000) når man rykker over start.
TODO: Balance gemmes ikke i csv.
TODO: Hvis man slår dobbelt tre gange i træk, så ryger man i fængsel.
TODO: Nogle chancekort er ikke implementeret endnu.
André — Today at 9:10 AM
TODO: Pantsætning er ikke implementeret
TODO: Når man starter nyt spil, har spillerne ingen penge.
*
* */
public class Main {
    static ArrayList<Game> games = new ArrayList<>();
    static int currentID;



    public static void main(String[] args) {

        Game game = new Game("Monopoly");

        games.add(game);


        game.runDialog();
        currentID = game.getID();
    }

    public static Game getCurrentGame() {
        return games.get(currentID);
    }



}

