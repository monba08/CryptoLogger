import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //private Accounts Account;

    public static void main(String[] args)  throws IOException {

            System.out.println("Welcome to CryptoLogger!");
            Accounts account = new Accounts();
            Portfolio portfolio = new Portfolio();
            File inputFile = new File("Accounts.txt");
            ExistingUser user = new ExistingUser();
            try {
                boolean exit =false;
                Scanner scan = new Scanner(System.in);
                while (!exit) {
                    // Print menu
                    System.out.println("\nMenu:\n\n"
                            + "Option 1 - Create a new account              \n"
                            + "Option 2 - Access Portfolio                  \n"
                            + "Option 3 - Remove coin                       \n"
                            + "Option 4 - Exit                              \n");
                    int option = scan.nextInt();
                    switch (option)
                    {
                        case 1:
                            account.createNewAccount();
                            break;
                        case 2:
                            portfolio.readFromFile(inputFile);
                            portfolio.getName();
                            break;
                        case 3:
                            user.removeCoin(inputFile); // Aanroep voor het verwijderen van een coin in de arraylist
                            break;
                        case 5:
                            exit=true;
                        default:
                            System.out.println("Option doesn't exist, please try again.");
                            break;
                    }
                }
            }catch (IOException e) {
        e.printStackTrace();
    }




    }
}

  /*String filename = "C:\\Users\\mouhc\\Google Drive\\Desktop\\School\\Uni3\\Semester 6\\Software Design\\CryptoTrack\\Test.xls";
        File inputWorkBook = new File(filename);
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
