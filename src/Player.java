
public class Player {
    // Attributes
    private String name;
    private int balance;
    private final static int startMoney = 30000;

    public Player(String name, int balance) {
        // This Constructor is used to give a player a customizable amount of money
        this.name = name;
        this.balance = balance;
    }   // end Constructor

    public Player(String name) {
        // Creates a default player with 30000 money
        this.name = name;
        this.balance = startMoney;
    }   // end Constructor

    public Player() {

    }

    public void addToBalance(int amount) {
        this.setBalance(this.balance+amount);
    }   // end addToBalance()

    public void setBalance(int amount){
        this.balance = amount;
    }   // end setBalance()
    
    public String getName() {
        return this.name;
    }   // end getName()

    public Player getPlayer() {
        return this;    // this
    }   // end getPlayer()

    public String toString(){
        return this.name + ", "+ this.balance;
    }   // end toString()
}   // end Customer