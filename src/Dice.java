public class Dice {
    private int dice1;
    private int dice2;

    public Dice (){
    }   // end constructor

    public int throwDie(){
    double calc;
    do {
        calc = Math.random()*6;
    }    while (calc < 1 || calc > 6 );

    return (int)(calc);
    }   // end throwDie()

    public int getDice1(){
        return dice1;
    }   // end getDice1()

    public int getDice2() {
        return dice2;
    }   // end getDice2()

    public int getDieSum(){
        dice1 = throwDie();
        dice2 = throwDie();
        return getDice1() + getDice2();
    } // end getDieSum

    public boolean prisonRoll(){
        dice1 = throwDie();
        dice2 = throwDie();
        if (dice1 == dice2){
            System.out.println("Congratulations! You have have escaped prison! Bt rolling" + getDice1() + " & " + getDice2());
            return true;
        } else {
            System.out.println("Your shouldn't have commited tax fraud you DUMB fuck!\nYou rolled " + getDice1() + " & " + getDice2() + " you wasn't able to bribe the prison guard!");
            return false;
        }   // end if-else statement
    }   // end prisonRoll()
}
