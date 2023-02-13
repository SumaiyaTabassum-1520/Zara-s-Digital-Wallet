package projectdigitalwallet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class monetaryTransaction {

    private String title;
    private String description;
    private double amount;
    private String dateOfEvent;
    private SimpleDateFormat sf= new SimpleDateFormat("dd/MM/yyyy");
    monetaryTransaction() {
        
        title="";
        description="";
        amount=0;
        dateOfEvent=sf.format(new Date());
        

    }
    monetaryTransaction(String Title, String Description, double Amount, String DateOfEvent ) {
        
        this.title=Title;
        this.description=Description;
        this.amount=Amount;
        this.dateOfEvent=DateOfEvent;
        

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDateOfEvent() {

        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {

        this.dateOfEvent = dateOfEvent;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public Date getDateOfEventasDate() {
        try{
            return sf.parse(dateOfEvent);
        }
        catch(ParseException ex){
            return new Date();  
        }
    }
}
