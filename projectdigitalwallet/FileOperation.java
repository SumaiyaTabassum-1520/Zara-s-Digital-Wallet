
package projectdigitalwallet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class FileOperation {

    private final String fileName;
    private final ArrayList<String> allData=new ArrayList<>();
    private int currentIndex;
    public int startRead;
    public int endRead;
    FileOperation(String className) {
        fileName = className + ".txt";
        startRead=0;
        endRead=-1;
    }
   
    File file;//new File(fileName);

    void WriteToFile(String data) {

        try {
            file = new File(fileName);
            file.createNewFile();
            try (FileWriter output = new FileWriter(file)) {
                output.write(data);
            }
            

        } catch (IOException ex) {
            System.out.println("Exception: " + ex);

        }

    }

    void AppendToFile(String data) throws FileNotFoundException {
        file = new File(fileName);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            try (FileWriter output = new FileWriter(file,true)) {
                output.append(data);
                output.append('\n');
            }
        }
        catch(IOException ex){
            System.out.println("Exceptions: "+ex);
        }

    }

    String ReadFromFile() throws FileNotFoundException {
        file = new File(fileName);
        String res;
        try (Scanner input = new Scanner(file)) {
            res = "";
            while (input.hasNext()) {
                res = input.next();
                
            }
        }
        return res;
    }
    
    void ReadAllLines() throws IOException{
        currentIndex=0;
        file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                allData.add(line);
                i++;
            }
        } catch (IOException e) {
        }
        
    }
    String ReadNextLine(){
        String temporary ="";
        if(currentIndex<allData.size()){
            temporary = allData.get(currentIndex);
            currentIndex++;
        }
        return temporary;
    }
}