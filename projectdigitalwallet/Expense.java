package projectdigitalwallet;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Expense extends monetaryTransaction implements iReadData, iWriteData {

    private String category;
    private String place;

    private static FileOperation exFile = new FileOperation("Expense");

    Expense() {
        super();
        category = "";
        place = "";
    }

    Expense(String C, String P, String Title, String Description, double Amount, String DateOfEvent) {

        super(Title, Description, Amount, DateOfEvent);
        this.category = C;
        this.place = P;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getPlace() {

        return place;
    }

    public void setPlace(String place) {

        this.place = place;
    }

    @Override
    public boolean readData() {
        boolean readSuccess=false;
        try {
            if(Expense.exFile.startRead==0){
                Expense.exFile.ReadAllLines();
                Expense.exFile.startRead=-1;
                Expense.exFile.endRead =0;
            }
            String data = Expense.exFile.ReadNextLine();
            String[] parsedData = data.split(",");
            super.setTitle(parsedData[0]); 
            super.setDescription(parsedData[1]); 
            super.setAmount(Double.parseDouble(parsedData[2]));
            super.setDateOfEvent(parsedData[3]);
            category =parsedData[4];
            place=parsedData[5];
            readSuccess=true;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return readSuccess;
    }

    @Override
    public void writeData() {
        try {
            exFile.AppendToFile(super.getTitle() + "," + super.getDescription() + "," + super.getAmount() + "," + super.getDateOfEvent() + "," + category + "," + place);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception "+ex);
        }
    }

}
