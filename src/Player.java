import java.util.ArrayList;

public class Player {

    private String name;
    private int position;
    Account account;
    ArrayList<Field> deeds;
    private int destination;
    private int paymentTimes = 1;



    private boolean isBankrupt = false;
    private boolean inPrison = false;

    public Player (String name){
       this(name, 0);
    }

    public Player (String name, int startAmount){
        this.name = name;
        this.position = 1;
        this.account = new Account();
        account.deposit(startAmount);

        this.deeds = new ArrayList<>();
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

       public boolean pay(int amount){
        if(account.withdraw(amount)){
            return true;
        }else {
            isBankrupt = true;

        }
        return false;
    }

    public boolean pay(int amount, Player recipient){
      boolean succes = pay(amount);
      if (succes){
          recipient.receive(amount);
          return true;
      }
        return false;
    }

    public boolean buyProperty(Field f){
        if(pay(f.cost)){
        deeds.add(f);
        return true;
       } else {
           return false;
       }
    }

    public int getWorthInCash(){

        return account.getBalance();
    }

    public int getTotalWorth(){
        int total = 0;
        for (Field f : deeds){
            total += f.cost;
        }
        return total += getWorthInCash();
    }

      public void moveToPrison(){
        this.position = 11;
        this.inPrison = true;
    }

    public int getPosition(){
        return this.position;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }
    public int getDestination() {
        return destination;
    }

    public void setPaymentTimes(int paymentTimes) {
        this.paymentTimes = paymentTimes;
    }

    public int getPaymentTimes() {
        return paymentTimes;
    }
}
