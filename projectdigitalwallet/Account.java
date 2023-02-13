package projectdigitalwallet;


import java.util.*;

public class Account implements iBasicAccountActions {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Calendar dateCreated;

    Scanner input = new Scanner(System.in);
    

    Account() {
        id = 0;
        balance = 0.0;
        annualInterestRate = 0.0;

    }

    Account(int I, double B, double R) {
        this.id = I;
        this.balance = B;
        this.annualInterestRate = R;
        this.dateCreated = Calendar.getInstance();

    }

    public int getid() {
        return id;
    }

    public void setid(int I) {
        this.id = I;
    }
    
    public void setBalance(double D) {
        this.balance = D;
    }

    public double getannualInterestRate() {
        return annualInterestRate;
    }

    public void setannualInterestrate(double R) {
        this.annualInterestRate = R;
    }

    public Calendar getdateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {

        double monthlyInterestRate = ((annualInterestRate / 12) / 100);
        return monthlyInterestRate;

    }

    public double getMonthlyInterestAmount() {

        double monthlyInterestAmount = balance * getMonthlyInterestRate();
        return monthlyInterestAmount;
        
    }



    public String display() {

        return "Account Balance : " + balance + "\n" + "Monthly Interest amount : " + getMonthlyInterestAmount() + "%" + "\n" + "The current date is : " + dateCreated.getTime();
    }

    public void DipositeAmmount() {
        System.out.println("Enter the amount of diposite : ");
        double amount = input.nextDouble();
        if (amount < 0) {
            System.out.println("This amount can not be diposite");

        } else {

            System.out.println("After diposite balance is " +deposit(amount));
        }
    }
    @Override
    public double getBalance() {
        return balance;
    }
    @Override
    public double withdraw(double amount) {
        if(amount<balance){
        
            balance = balance - amount;
        }
        else{
            //throw exception
        }
        return balance;
    }

    @Override
    public double deposit(double amount) {
        balance = balance + amount;
        return balance;
    }

    

}

