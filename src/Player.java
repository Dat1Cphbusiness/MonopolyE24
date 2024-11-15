import java.util.ArrayList;

public class Player {

    private String name;
    private int position;
    Account account;
    ArrayList<Field> deeds;

    public Player (String name){
       this(name, 0);
    }

    public Player (String name, int startAmount){
        this.name = name;
        this.position = 1;
        this.account = new Account();
        account.deposit(startAmount);

        this.deeds = new ArrayList<>();
    }

    public String toString(){
        return this.name + ", "+ this.account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value) {
        // if we pass Start
        if (position+value > 40){
            receive(4000);
            position = (position + value) - 40;
        }
        else{
            position += value;
        }
        return position;
    }

    public void receive(int amount){
        account.deposit(amount);
    }

   //todo: begge pay metoder skal returnere en boolean.
   // Værdien der skal returneres, kommer fra kald til withdraw og vil være false hvis der ikke var penge nok på kontoen til at trække bekøbet
    public void pay(int amount){
        account.withdraw(amount);
    }
    //todo: træf beslutning: skal modtageren have pengene selvom betaleren går i minus?
    public void pay(int amount, Player recipient){
        pay(amount);
        recipient.receive(amount);
    }
    //todo: tilføj kun f til deeds hvis betalingen gik godt
    public boolean buyProperty(Field f){
        pay(f.cost);
        deeds.add(f);
        return true;
    }

    public int getWorthInCash(){

        return account.getBalance();
    }

    public int getTotalWorth(){
        int total = 0;
        for (Field f : deeds){
            total += f.cost;
        }
        return total += getWorthInCash();
    }

   //todo: Denne metode kommer vist ikke til at virke. Man kan ryge i fængsel fra et hvilket som helst felt. Hvordan kan vi løse denne?
    public int moveToPrison(){
        //hen på 11
        //set flag boolean inPrison
        return updatePosition(11 - position);
    }

    public int getPosition(){
        return this.position;
    }
}
