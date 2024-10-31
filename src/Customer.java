
public class Customer {

    private String name;
    private int balance;
    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addToBalance(int amount) {
        this.setBalance(this.balance+amount);
    }
    public void setBalance(int amount){
        this.balance = amount;
    }


    public String toString(){
        return this.name + ", "+ this.balance;
    }

}
