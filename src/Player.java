public class Player {

    private String name;
    private int balance;
    private final static int startBalance = 30000;
    private int postion;
    private Account account;

    public Player (String name){
        this.name = name;
        this.balance = startBalance;
        this.account = null;
    }


    public int updatePosition(int value){
        postion = value;
        return postion;
        if(postion == field.value[1]){

        }
    }

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String toString(){
        return this.name + ", "+ this.balance;
    }

    public String getName() {
        return name;
    }


    public void recieve(int amount) {
        account.deposit(amount);
    }
}
