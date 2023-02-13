package projectdigitalwallet;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Person implements iReadData,iWriteData{

    private String name;
    private String dateOfBirth;
    private String emailId;
    private int phone;
    private int nationalId;
    private int age;
    Calendar dob = new GregorianCalendar();
    Calendar cal = new GregorianCalendar();
    private FileOperation pFile = new FileOperation("Person");
    
    Person() {
        name="";
        dateOfBirth="";
        emailId="";
        phone=0;
        nationalId=0;
        age=0;
        
    }
    Person(String Name,String DOB,String Email,int Phn,int NID){
        this.name=Name;
        this.dateOfBirth=DOB;
        this.emailId=Email;
        this.phone=Phn;
        this.nationalId=NID;
        
    }
    
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailId() {

        return emailId;
    }

    public void setEmailId(String emailId) {

        this.emailId = emailId;
    }

    public int getPhone() {

        return phone;
    }

    public void setPhone(int phone) {

        this.phone = phone;
    }

    public int getNationalId() {

        return nationalId;
    }

    public void setNationalId(int nationalId) {

        this.nationalId = nationalId;
    }

    public int getAge() {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date dt = sf.parse(dateOfBirth);
            dob.setTime(dt);
        }
        catch(ParseException ex){
            System.out.println("Exception: "+ex);
        }
        age=cal.get(Calendar.YEAR)-dob.get(Calendar.YEAR);
        return age;
    }
    

    @Override
    public void writeData() {
        pFile.WriteToFile(name + "," + dateOfBirth + "," + nationalId + "," +emailId +","+phone);
    }

    @Override
    public boolean readData() {
        boolean readSuccess=false;
        try{
            String data = pFile.ReadFromFile();
            String[] parsedData = data.split(",");
            name = parsedData[0];
            this.dateOfBirth=parsedData[1];
            this.nationalId=Integer.parseInt(parsedData[2]);
            this.emailId=parsedData[3];
            this.phone= Integer.parseInt(parsedData[4]);
            readSuccess=true;
        }
        catch(FileNotFoundException | NumberFormatException ex){
            System.out.println(ex);
        }
        return readSuccess;
    }

}
