import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class Main {
    //private Accounts Account;

    public static void main(String[] args)  throws IOException{

        System.out.println("Welcome to CryptoLogger!");
        Accounts account = new Accounts();
        account.createNewAccount();
        String filename = "C:\\Users\\mouhc\\Google Drive\\Desktop\\School\\Uni3\\Semester 6\\Software Design\\CryptoTrack\\Test.xls";
        /*File inputWorkBook = new File(filename);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkBook);
            Sheet sheet = w.getSheet(0);
            for (int i = 0; i < sheet.getColumns(); i++) {
                for (int j = 0; j < sheet.getRows(); j++) {
                    Cell cell = sheet.getCell(i,j);
                    CellType type = cell.getType();
                    if(type==CellType.LABEL)
                    {
                        System.out.println("I got a label" + cell.getContents());
                    }
                    if(type==CellType.NUMBER)
                    {
                        System.out.println("I got a number: "+ cell.getContents());
                    }
                }
            }


        } catch (BiffException e) {
            e.printStackTrace();
        }*/
        Portfolio portfolio = new Portfolio();

    }
}
