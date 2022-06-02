package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream fis=null;
    public FileInputStream getFile(){
        String path= System.getProperty("user.dir")+"src/test/java/Data/user_Data.xlsx";
        File srcFile=new File(path);
        try {
            fis=new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return fis;
    }
    public  Object[][]getExcelData(){
        fis=getFile();
        XSSFWorkbook wb= null;
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet=wb.getSheetAt(0);
        int totalNumberOfRows=(sheet.getLastRowNum()+1);
        int totalNumberOfCols=4;
        String [][]arrayExcelData= new String[totalNumberOfRows][totalNumberOfCols];
        for(int i=0;i<totalNumberOfRows;i++){
            for(int j=0;j<totalNumberOfCols;j++){
                XSSFRow row=sheet.getRow(i);
                arrayExcelData[i][j]=row.getCell(j).toString();
            }
        }
       // wb.close();
        return  arrayExcelData;

    }
}
