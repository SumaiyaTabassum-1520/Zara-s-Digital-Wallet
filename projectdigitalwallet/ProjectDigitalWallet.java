package projectdigitalwallet;

import java.util.*;

public class ProjectDigitalWallet {
    
    
    Scanner input=new Scanner(System.in);
    Wallet wt = new Wallet();
    Person p = new Person();
    
    public int printMenu() {
        System.out.println("\n\t\tGreetings "+p.getName()+" Please Select an Option:");
        System.out.println("\n\t Enter 1 to Add ");
        System.out.println("\t Enter 2 to purchase ");
        System.out.println("\t Enter 3 to Print  wallet information");
        System.out.println("\t Enter 4 to budgeting");
        System.out.println("\t Enter 5 to show personal info");
        System.out.println("\t Enter 6 to exit");
        return 1;
    }
    public void printAdd() {
        System.out.println("Enter 1 to add monthly earning ");
        System.out.println("Enter 2 to add daily expense ");
        
    }
    public void printPurchase() {
        System.out.println("Enter a to shopping");
        System.out.println("Enter b to pay electricity bill");
        System.out.println("Enter c to pay mobile bill");
    }
    public void printTransaction() {
        System.out.println("Enter 1 to transaction from own wallet");
        System.out.println("Enter 2 to transaction in another wallet");
    }
    public void printWalletInformation() {
        System.out.println("Enter 1 to print summary");
        System.out.println("Enter 2 to print daily expense");
        System.out.println("Enter 3 to print monthly expense");
        System.out.println("Enter 4 to print monthly earning");
    }
    public void printFirstTimeWelcomeMenu(){
        System.out.println("\n\t\t Welcome to Digital Wallet");
        System.out.println("\t\t This is the first time we are meeting lets get to know each other");
        System.out.println("\t\t Please tell me your name:");
        String Name=input.nextLine();
        System.out.println("Please enter your email id:");
        String EmailId=input.nextLine();
        System.out.println("Please enter your Date of birth (dd/MM/yyyy)");
        String DOB=input.nextLine();
        System.out.println("Plese enter your NID number");
        int NID=input.nextInt();
        System.out.println("Please enter your phone number");
        int phnNumber=input.nextInt();
        p=new Person(Name,DOB,EmailId,phnNumber,NID);
        p.writeData();
    }
    public void AddRelatedWork(){
        printAdd();
        int number=input.nextInt();
        switch(number){
            case 1:
                System.out.println("Monthly earning");
                wt.addEarning();
                break;
            case 2:
                System.out.println("Daily expence: ");
                wt.addExpense();
                break;
        }
    }
    public void PurchaseRelatedWork(){
        System.out.println("There is a bug in project so this project can not purchase");
    }
    public void WalletInformation(){
        printWalletInformation();
        int number=input.nextInt();
        switch(number){
            case 1:
                System.out.println("Total earning"+wt.GetTotalEarning());
                System.out.println("Total expense"+wt.GetTotalExpense());
                break;
            case 2:
                System.out.println("Daily expense :"+wt.getTodaysExpense());
                break;
            case 3:
                System.out.println("Monthly expense:"+wt.getMonthlyExpense());
                break;
            case 4:
                System.out.println("Monthly earning :"+wt.getMonthlyEarning());
                break;          
        }
    }
    public void ShowPersonalInfo(){
        System.out.println("Name :"+p.getName());
        System.out.println("DOB:"+p.getDateOfBirth());
        System.out.println("Age :"+p.getAge());
        System.out.println("EmailId :"+p.getEmailId());
        System.out.println("Phone Number :"+p.getPhone());
        System.out.println("NID :"+p.getNationalId());
    }
    public void BudgetingWork(){
        System.out.println("Only Standard Budget available at this moment");
        System.out.println("Budgeting Percentage:"+wt.BudgetInfo());
        System.out.println("Amount :"+wt.BudgetInfoAmount());
        System.out.println("Remaining balance necessity: "+wt.GetRemainingMonthlyAmountGivenCategory("necessity"));
        System.out.println("Want"+wt.GetRemainingMonthlyAmountGivenCategory("want"));
        System.out.println("Savings :"+wt.GetRemainingMonthlyAmountGivenCategory("savings"));
        
        
    }
    public void ClosingApp(){
        System.out.println("Saving Necessary Informations");
        p.writeData();
        wt.SaveWalletData();
        System.out.println("Saving Complete...");
        System.out.println("EXiting...");
    }
    public void run(){
        if(!p.readData()){
            printFirstTimeWelcomeMenu();
        }
        
        while(printMenu()==1 ){
            int choice=input.nextInt();
                switch(choice){
                case 1:
                   AddRelatedWork();
                   break;
                case 2:
                    PurchaseRelatedWork();
                    break;
                case 3:
                    WalletInformation();
                    break;
                case 4:
                    BudgetingWork();
                    break;
                case 5:
                    ShowPersonalInfo();
                    break;
                case 6:
                    ClosingApp();
                    System.exit(0);
                    break;
            }
            
        }
    }
    
    public static void main(String[] args) {
       ProjectDigitalWallet driver = new ProjectDigitalWallet();
       driver.run();
    }
    
}
