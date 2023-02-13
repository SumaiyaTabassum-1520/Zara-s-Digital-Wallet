package projectdigitalwallet;

import java.io.FileNotFoundException;

public class Bank implements iReadData, iWriteData {

    private String bankName;
    private String branchName;

    iBasicAccountActions Acc = new Account();
    private FileOperation bFile = new FileOperation("Bank");

    Bank() {
        bankName = "";
        branchName = "";
        Acc=new Account();
    }

    Bank(String BankName, String Branchname) {
        this.bankName = BankName;
        this.branchName = Branchname;
    }

    public String getBankName() {

        return bankName;
    }

    public void setBankName(String bankName) {

        this.bankName = bankName;
    }

    public String getBranchName() {

        return branchName;
    }

    public void setBranchName(String branchName) {

        this.branchName = branchName;
    }

    public double makeDeposit(double amount) {
        return Acc.deposit(amount);
    }

    public double makeWithdraw(double amount) {
        return Acc.withdraw(amount);
    }

    public double CurrentBalance() {
        return Acc.getBalance();
    }

    public void AuthorizeAccount() {
        System.out.println("Lets Assume User Authorized Acc Id: 3325498 With Pin: 9798");
        System.out.println("Bank Returned following information");
        Acc = new Account(3325498, 15000, 4.5);
    }
    
    public void loadBankData(){
        if(!readData()){
            AuthorizeAccount();
        }
    }
    
    @Override
    public boolean readData() {
        boolean readSuccess=false;
        try {
            String data = bFile.ReadFromFile();
            String[] parsedData = data.split(",");
            this.bankName = parsedData[0];
            this.branchName = parsedData[1];
            this.Acc.deposit(Double.parseDouble(parsedData[2]));
            readSuccess=true;

        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex);
        }
        return readSuccess;
    }

    @Override
    public void writeData() {
        bFile.WriteToFile(bankName + "," + branchName + ","+Acc.getBalance());
    }

}
