package projectdigitalwallet;

import java.io.FileNotFoundException;
//import java.io.IOException;

public class Earning extends monetaryTransaction implements iReadData, iWriteData {

    private String source;
    private static FileOperation earningFile = new FileOperation("Earning");

    Earning() {
        super();
        source = "";
    }

    Earning(String Source, String Title, String Description, double Amount, String DateOfEvent) {

        super(Title, Description, Amount, DateOfEvent);
        this.source = Source;
    }

    public String getSource() {

        return source;
    }

    public void setSource(String source) {

        this.source = source;
    }

    @Override
    public boolean readData() {
         boolean readSuccess=false;
        try {
            if (Earning.earningFile.startRead == 0) {
                Earning.earningFile.ReadAllLines();
                Earning.earningFile.startRead = -1;
                Earning.earningFile.endRead = 0;
            }
            String data = Earning.earningFile.ReadNextLine();
            String[] parsedData = data.split(",");
            super.setTitle(parsedData[0]);
            super.setAmount(Double.parseDouble(parsedData[1]));
            super.setDescription(parsedData[4]);
            super.setDateOfEvent(parsedData[2]);
            source = parsedData[3];
            readSuccess=true;
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return readSuccess;
    }

    @Override
    public void writeData() {
        try {
            Earning.earningFile.AppendToFile(getTitle() + "," + getAmount() + "," + getDateOfEvent() + "," + getSource() + "," + getDescription());
        } catch (FileNotFoundException ex) {
            System.out.println("Exception" + ex);
        }
    }

}
