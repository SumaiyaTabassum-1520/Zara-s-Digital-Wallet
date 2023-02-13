package projectdigitalwallet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.*;

public class Wallet{

    private double monthlyBalance;
    private Date firstDayM;
    private Date lastdayM;
    private Date todayM;
    private Budget bdt;
    Bank BA=new Bank();
    AccountsRecords AR = new AccountsRecords();
    Scanner input=new Scanner(System.in);
    void SetFirstAndLastDate(LocalDate ld){
        LocalDate start = ld.withDayOfMonth(1);
        LocalDate end = ld.withDayOfMonth(ld.getMonth().length(ld.isLeapYear()));
        firstDayM = Utility.LocalDateToDate(start);
        lastdayM = Utility.LocalDateToDate(end);
    }
    Wallet() {
        bdt= new Budget();
        LocalDateTime now = LocalDateTime.now();
        todayM = Utility.LocalDateTimeToDate(now);
        SetFirstAndLastDate(now.toLocalDate());
        if(!BA.readData()){
            InsertTestBankData();
        }
        AR.LoadAccountData();
        monthlyBalance=4500;
    }
    void InsertTestBankData(){
        BA.AuthorizeAccount();
        BA.setBankName("EBL");
        BA.setBranchName("Santinagar");
    }
    void InesertTestWalletData(){
        
    }
    double GetRemainingMonthlyAmountGivenCategory(String category){
        double ret = -1;
        double expense= AR.GetTotalExpenceGivenCategory(firstDayM, todayM, category);
        double budgetAmount = bdt.budgetAmountGivenCategory(monthlyBalance,category);
        ret = budgetAmount-expense;
        return ret;
    }
    
    double GetTotalEarning(){
        return AR.GetTotalEarning(firstDayM, todayM);
    }
    double GetTotalExpense(){
        return AR.GetTotalExpence(firstDayM, todayM);
    }
    double getTodaysExpense(){
        return AR.GetTotalExpence(todayM, todayM);
    }
    double getMonthlyExpense(){
        return AR.GetTotalExpence(firstDayM, lastdayM);
    }
    double getMonthlyEarning(){
        return AR.GetTotalEarning(firstDayM, lastdayM);
    }
    void addEarning(){
        double earnedAmount = AR.AddEarning();
        monthlyBalance+=earnedAmount;
        BA.makeDeposit(earnedAmount);
    }
    void addExpense(){
        System.out.println("Insert category (necessity,want)");
        String category=input.nextLine();
        System.out.println("Insert Pin");
        String pin=input.nextLine();
        
        double expenseAmount=AR.AddExpense(category);
        double previousBalance = BA.CurrentBalance();
        double balanceAfter= BA.makeWithdraw(expenseAmount);
        System.out.println("Expense Amount " + expenseAmount + " \nPreviousBalance " + previousBalance + "\nCurrent Balance" + balanceAfter);
        System.out.println("Remaining balance in category: "+ category +"Amount: "+GetRemainingMonthlyAmountGivenCategory(category));
    }
    String BudgetInfo(){
            return "Necessity: "+bdt.getNecessity()+"% Want: "+bdt.getWant()+"% Savings: "+bdt.getSaving()+"%";
    }
    String BudgetInfoAmount(){
        return "Necessity: "+bdt.getNecessityAmount(monthlyBalance)+" Want: "+bdt.getWantAmount(monthlyBalance)+" Savings: "+bdt.getSavingAmount(monthlyBalance);
    }
    void SaveWalletData(){
        AR.SaveAccountData();
        BA.writeData();
    }
}
