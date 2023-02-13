package projectdigitalwallet;
import java.util.*;
public class AccountsRecords {
    List<Earning> EA =new ArrayList<>();
    List<Expense> EX =new ArrayList<>();
    Scanner input=new Scanner(System.in);
    AccountsRecords(){
        
    }
    void SaveAccountData(){
        iWriteData iwd;
        for(int i=0;i<EA.size();i++){
            iwd = EA.get(i);
            iwd.writeData();
        }
        for(int i=0;i<EX.size();i++){
            iwd=EX.get(i);
            iwd.writeData();
        }
    }
    void LoadAccountData(){
        iReadData ird;
        Expense temp = new Expense();
        ird=temp;
        while(ird.readData()){
            EX.add(temp);
            temp = new Expense();
            ird=temp;
        }
        if(EX.isEmpty()){
            InsertTestExpenseData();
        }
        Earning eatemp = new Earning();
        ird=eatemp;
        while(ird.readData()){
            EA.add(eatemp);
            eatemp = new Earning();
            ird=temp;
        }
        if(EA.isEmpty()){
            InsertTestEarningData();
        }
    }
    
    private double InsertTestEarningData(){
        EA.add(new Earning("Baba","PocketMoney","Masher Khoroch",3000,"01/05/2022"));
        EA.add(new Earning("Ripani","FoodMoney","To Eat Lunch at Canteen",500,"04/05/2022"));
        EA.add(new Earning("Boro Mama","Salami","Late Salami of Eid ul adha",1000,"07/05/2022"));
        return 3000+500+1000;
    }
    private void InsertTestExpenseData(){   
        EX.add(new Expense("Necessity","Big Bazar","Kitkat","Chocolate for Lopani",60,"02/05/2022"));
        EX.add(new Expense("Necessity","Basa To Campus","Rickshaw","Up down cost for basa to campus",120,"05/05/2022"));
        EX.add(new Expense("Want","Baily Star","Hello Kitty Watch","I wanted this watch for a long time now its mine.",250,"06/05/2022"));
        EX.add(new Expense("Necessity","Cafeteria","Signara","Worst place to eat. Never doing it again",40,"07/05/2022"));
    
    }
    double AddExpense(){
        System.out.println("Enter title");
        String title=input.nextLine();
        System.out.println("Enter category");
        String category=input.nextLine();
        System.out.println("Enter amount");
        Double amount=input.nextDouble();
        System.out.println("Enter place");
        String place=input.nextLine();
        input.nextLine();
        System.out.println("Enter description");
        String description=input.nextLine();
        System.out.println(Utility.GetCurrentDate());
        EX.add(new Expense(category,place,title,description,amount,Utility.GetCurrentDateAsString()));
        return amount;
    }
    
    double AddExpense(String category){
        System.out.println("Enter title");
        String title=input.nextLine();
        System.out.println("Category : "+category);
        System.out.println("Enter amount");
        Double amount=input.nextDouble();
        System.out.println("Enter place");
        String place=input.nextLine();
        input.nextLine();
        System.out.println("Enter description");
        String description=input.nextLine();
        System.out.println(Utility.GetCurrentDate());
        EX.add(new Expense(category,place,title,description,amount,Utility.GetCurrentDateAsString()));
        return amount;
    }
    double AddEarning(){
        System.out.println("Enter title");
        String title=input.nextLine();
        System.out.println("Enter amount");
        Double amount=input.nextDouble();
        input.nextLine();
        System.out.println("Enter description");
        String description=input.nextLine();
        System.out.println("Enter source");
        String source=input.nextLine();
        System.out.println(Utility.GetCurrentDate());
        EA.add(new Earning(source,title,description,amount,Utility.GetCurrentDateAsString()));
        return amount;
    }
    boolean isWithinRange(Date startDate, Date endDate, Date eventDate){
        return eventDate.after(startDate) && eventDate.before(endDate);
    }
    int GetTotalExpence(Date fromDate,Date toDate){
        int result=0;
        for(int i=0;i<EX.size();i++){
           Expense e = EX.get(i);
           if(isWithinRange(fromDate,toDate,e.getDateOfEventasDate())){
               result+=e.getAmount();
           }
       } 
       return result;
    }
    ArrayList<Expense> GetTotalExpenceList(Date fromDate,Date toDate){
        ArrayList<Expense> ret=new ArrayList<>();
        for(int i=0;i<EX.size();i++){
           Expense e = EX.get(i);
           if(isWithinRange(fromDate,toDate,e.getDateOfEventasDate())){
               ret.add(e);
           }
       } 
       return ret;
    }
    int GetTotalExpenceGivenCategory(Date fromDate,Date toDate,String category){
        int result=0;
        for(int i=0;i<EX.size();i++){
           Expense e = EX.get(i);
           if(isWithinRange(fromDate,toDate,e.getDateOfEventasDate())&&e.getCategory().toLowerCase().equals(category.toLowerCase())){
               result+=e.getAmount();
           }
       } 
       return result;
    }
    ArrayList<Expense> GetTotalExpenceListGivenCategory(Date fromDate,Date toDate,String category){
        ArrayList<Expense> ret=new ArrayList<>();
        for(int i=0;i<EX.size();i++){
           Expense e = EX.get(i);
           if(isWithinRange(fromDate,toDate,e.getDateOfEventasDate())&&e.getCategory().toLowerCase().equals(category.toLowerCase())){
               ret.add(e);
           }
       } 
       return ret;
    }
    int GetTotalEarning(Date fromDate,Date toDate){
        int result=0;
        for(int i=0;i<EA.size();i++){
           Earning e = EA.get(i);
           if(isWithinRange(fromDate,toDate,e.getDateOfEventasDate())){
               result+=e.getAmount();
           }
       } 
       return result;
    }
    ArrayList<Earning> GetTotalEarningList(Date fromDate,Date toDate){
        ArrayList<Earning> ret = new ArrayList<>();
        for(int i=0;i<EA.size();i++){
           Earning e = EA.get(i);
           if(isWithinRange(fromDate,toDate,e.getDateOfEventasDate())){
               ret.add(e);
           }
       } 
       return ret;
    }
}

