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

    public void pay(int amount){
        boolean successFullWithdraw = account.withdraw(amount);
    }

    public void pay(int amount, Player recipient){
        boolean successFullWithdraw = account.withdraw(amount);
        pay(amount);
        recipient.receive(amount);
    }

    public boolean buyProperty(Field f){
        pay(f.cost);
        deeds.add(f);
        return true;
    }

    public int getWorthInCash(){
        account.getBalance();
        return account.getBalance();
    }


    public int getTotalWorth(){
        int total = getWorthInCash();
        for (Field f : deeds){
            total += f.cost;
        }
        return total;
    }
    public void moveToPrison(){
        int fieldsToPrison = 11 - position;
        updatePosition(fieldsToPrison);
    }
}
