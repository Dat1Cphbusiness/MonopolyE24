
public class Player {
    // Attributes
    private String name;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }   // end Constructor

    public void addToBalance(int amount) {
        this.setBalance(this.balance+amount);
    }   // end addToBalance

    public void setBalance(int amount){
        this.balance = amount;
    }   // end setBalance
    
    public String getName() {
        return this.name;
    }

    public String toString(){
        return this.name + ", "+ this.balance;
    }   // end toString
}   // end Customer