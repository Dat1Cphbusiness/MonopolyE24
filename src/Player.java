public class Player {

    private String name;
    private int position;
    Account account;

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

    public void pay(int amount, String name){
        account.withdraw(amount);
    }

    public int getPosition() {return position;}
}
