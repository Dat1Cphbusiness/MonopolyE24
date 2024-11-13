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
        this.deeds = deeds;
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

    public void pay(int amount){
        account.withdraw(amount);
    }

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
    public void pay(int amount, Player recipient){
        pay(amount);
        recipient.receive(amount);
    }

    public int moveToPrison(){
        return updatePosition(11 - position);
    }

    public int getPosition(){
        return this.position;
    }
}
