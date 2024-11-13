import java.util.ArrayList;

public class Player {

    private String name;
    private int position;
    Account account;
    private ArrayList<Field> deeds = new ArrayList<>();

    public Player (String name){
       this(name, 0);
    }

    public Player (String name, int startAmount){
        this.name = name;
        this.position = 1;
        this.account = new Account();
        account.deposit(startAmount);
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

    public boolean pay(int amount){
        account.withdraw(amount);
        return true;
    }

    public boolean buyProperty(Field f){
        pay(f.cost);
        deeds.add(f);
        return true;
    }

    public int getWorthInCash(){
        return account.getBalance();
    }

    public int getTotalWorth(){ // vi er ikke sikre på dette for each loop..
        int totalField = 0;
       for (Field f : deeds){
           totalField = f.cost+totalField;
       }
       return totalField;
    }

    public boolean pay(int amount, Player recipient){
        pay(amount);
        recipient.receive(amount);
        return true;
    }

    public int moveToPrison

}
