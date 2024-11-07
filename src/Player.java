
public class Player extends Game{
    // Attributes
    private String name;
    private int balance;
    private final static int startMoney = 30000;

    public Player(String name, int balance) {
        super("Matador");
        // This Constructor is used to give a player a customizable amount of money
        this.name = name;
        this.balance = balance;
    }   // end Constructor

    public Player(String name) {
        super("Matador");
        // Creates a default player with 30000 money
        this.name = name;
        this.balance = startMoney;
    }   // end Constructor

    public Player() {
        super("Matador");
    }   // end Constructor

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
        return this;
    }   // end getPlayer()

    public String toString(){
        return this.name + ", "+ this.balance;
    }   // end toString()
}   // end Customer