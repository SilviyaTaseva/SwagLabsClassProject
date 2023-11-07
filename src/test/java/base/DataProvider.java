package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "validUsersFromCsv")

    public Object[][]readValidUsersCSV(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUser.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvObject =new Object[csvData.size()][2];

            for (int i = 0; i< csvData.size(); i++){
                csvObject[i] = csvData.get(i);
            }
            return csvObject;
        }catch (IOException e){
            System.out.println("CSV file not found");
            return null;
        }catch (CsvException e){
            System.out.println("Invalid CSV file");
            return null;
        }
    }
    @org.testng.annotations.DataProvider( name = "unValidUsersFromCsv")
    public Object[][] readUnValidUsersFromCSV(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/uncorrectUser.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvObject = new Object[csvData.size()][2];

            for (int i = 0; i<csvData.size();i++){
                csvObject[i] = csvData.get(i);
            }
            return csvObject;
        }catch (IOException e){
            return null;
        }catch (CsvException e){
            return null;
        }
    }
}
