public class  Player {
    private String name;
    private int balance;


    public Player(String name, int startAmount){
        this.name = name;
        startAmount = getBalance();
        String deeds; //Developer B (deeds initialiserers)
        this.account = new Account(startAmount);

    }


    public void deposit(int amount){
        this.balance = this.balance + amount;
    }


    public String toString(){
        return this.name +", "+this.balance;
    }

    public int getBalance() {
        return this.account.getBalance();
    }

    public String getName() {
        return name;
    }

    public int updatePosition(int value){
        this.position = value;
        return position;
    }
}
