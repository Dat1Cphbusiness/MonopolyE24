public class  Player {
    private String name;

    //fjernet Balance
    private Account account; //Developer B (Account intialiseret)
    private int position;

    public Player(String name, int startAmount){
        this.name = name;
        startAmount = getBalance();
        String deeds; //Developer B (deeds initialiserers)
        this.account = new Account(startAmount);

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
        this.position = value;
        return position;
    }
}
