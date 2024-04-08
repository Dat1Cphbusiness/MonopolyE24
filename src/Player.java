import java.util.ArrayList;

public class  Player {
    private String name;
    private ArrayList<Field> deeds;
    private Account account;
    private int position;

    public Player(String name, int balance){
        this.name = name;

        deeds = new ArrayList<>();


        this.account = new Account(balance);
        this.setBalance(balance);
    }

    private void setBalance(int balance) {
        this.account.deposit(balance);
    }

    public String toString(){
        return this.name +", "+this.account.getBalance();
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value){
        this.position += value;
        return position;
    }

    public boolean buyProperty(Field f){
        f.getCost();
        boolean success = this.account.withdraw(f.getCost());
        return success;

    }

    public boolean pay(int amount){
        boolean success = this.account.withdraw(amount);
        return success;

    }

    public void receive(int amount){
        this.account.deposit(amount);

    }
    // this pay is for payRent
    public boolean pay(int amount, Player recipient){
        recipient.receive(amount);
        return pay(amount);

    }

    public void collect(int amount){
        for (Player p : Game.getPlayers()){
            p.pay(amount, this);

        }


    }


    public boolean startPassed(){
        return true;
    }

    public int getPosition(){
        return this.position;
    }
}
