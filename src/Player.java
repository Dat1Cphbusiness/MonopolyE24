
public class Player {

    private String name;
    private int balance;
    private final static int startBalance = 30000;
    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }


    public Player (String name){
        this.name = name;
        this.balance = startBalance;
    }

    public void addToBalance(int amount) {
        this.setBalance(this.balance+amount);
    }

    public String getName() {
        return name;
    }

    public void setBalance(int amount){
        this.balance = amount;
    }


    public String toString(){
        return this.name + ", "+ this.balance;
    }

}
