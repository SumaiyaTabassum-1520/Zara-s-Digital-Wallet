package projectdigitalwallet;

public class Budget {

    
    private int saving;
    private int necessity;
    private int want;

    Budget() {
        saving = 20;
        necessity = 60;
        want = 20;
    }

    Budget(int Demand, int Necessity, int Want) throws Exception {
        if((Want+Necessity+Demand) ==100){
            this.saving = Demand;
            this.necessity = Necessity;
            this.want = Want;
        }
        else{
            throw new Exception("Invalid Operation");
        }

    }
    
    double budgetAmountGivenCategory(double monthlyBalance,String category){
        if(category.equals("savings")){
            return getSavingAmount(monthlyBalance);
        }
        else if(category.equals("want")){
            return getWantAmount(monthlyBalance);
        }
        else{
            return getNecessityAmount(monthlyBalance);
        }
    }
    public void PersonalizeBudget(int saving,int necessity, int want)throws Exception{
        if((want+necessity+saving) == 100){
            this.saving = saving;
            this.necessity = necessity;
            this.want = want;
        }
        else{
            throw new Exception("Invalid Operation");
        }
    }
    public double getSavingAmount(double balance){
        return balance*(saving/100.0);
    }
    public double getNecessityAmount(double balance){
        return balance*(necessity/100.0);
    }
    
    public double getWantAmount(double balance){
        return balance*(want/100.0);
    }
    public int getSaving(){
        return saving;
    }
    
    public int getNecessity(){
        return necessity;
    }
   
    public int getWant(){
        return want;
    }
    
}
