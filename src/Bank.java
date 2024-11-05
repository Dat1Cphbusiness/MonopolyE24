import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Attributes
    private String name;
    private List<Player> customers;
    private TextUI ui;
    private FileIO io;
    private String customerDataPath;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.ui = new TextUI();
        this.io = new FileIO();
        this.customerDataPath="data/customerdata.csv";
    }   // end Construtor

    public void addCustomer(Player c){
        this.customers.add(c);
    }   // end addCustomer

    public String toString(){
        String str = "";
        for (Player c:customers) {
            str+=c+"\n";
        }   // end for-each loop
        return str;
    }   // end toString


    public List getCustomers() {
            return customers;
    }   // end getCustomer

    public void registerCustomer() {
        String continueDialog = "Y";
        while (continueDialog.equalsIgnoreCase("Y")) {

            String name = ui.promptText("Type name of customer:");
            int startAmount = ui.promptNumeric("Type start amount:");

            Player c = new Player(name, startAmount);
            this.addCustomer(c);

            continueDialog = ui.promptText("Do you wish to create another customer?Y/N");
        }   // end while-loop
    }   // end registerCustomer

   public void loadData(){
     ArrayList<String> data = io.readData(this.customerDataPath);

       if(!data.isEmpty()) {
           for (String s:data) {
               String[] values= s.split(",");
               String name = values[0];
               int balance = Integer.parseInt(values[1].trim());
               Player c = new Player(name, balance);
               customers.add(c);
           }    // end for-each loop
       }    // end if-statement
   }    // end loadData

    public void endSession(){
        ArrayList<String> customersAsText = new ArrayList<>();
        for (Player c:customers) {
            customersAsText.add(c.toString());
        }   // end for-each loop
        FileIO.saveData(customersAsText, this.customerDataPath, "name, balance");
    }   // end endSession
}   // End Bank
