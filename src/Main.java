
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //private Accounts Account;

    public static void  main(String[] args) {
        String coinType="";
        int valueCoin=0;
        int quantityCoin=0;
        try {
            System.out.println("Welcome to CryptoLogger!");
            Accounts account = new Accounts();
            Portfolio portfolio = new Portfolio();
            //File inputFile = new File("User.txt");
            ExistingUser user = new ExistingUser();
            Coin coin = new Coin(valueCoin, quantityCoin,coinType);
            boolean exit =false;
            Scanner scan = new Scanner(System.in);
            int option;
                while (!exit) {
                    // Print menu
                    System.out.println("\nMenu:\n\n"
                            + "Option 1 - Create a new account              \n"
                            + "Option 2 - Log In                            \n"
                            + "Option 3 - Access portfolio                  \n"
                            + "Option 4 - Remove coin                       \n"
                            + "Option 5 - Set current value                 \n"
                            + "Option 6 - Add new Coin                      \n"
                            + "Option 7 - Exit                              \n");
                    option= scan.nextInt();
                    //File inputFile = new File(userLoggedIn+".txt");
                    switch (option)
                    {

                        case 1:
                            account.createNewAccount("satish","satish","btc",50,50);
                            break;
                        case 2:
                        Scanner keyboard = new Scanner(System.in);
                            // looks at selected file in scan

                            System.out.println("Type in your username:");
                            String inpUser = keyboard.nextLine();
                            System.out.println("Type in your password:");
                            String inpPass = keyboard.nextLine();
                            account.logIn(inpUser,inpPass);
                            break;
                        case 3:
                            portfolio.readFromFile();
                            //portfolio.getName();
                            break;
                        case 4:
                            user.removeCoin(); // Aanroep voor het verwijderen van een coin in de arraylist
                            break;
                        case 5:
                            //coin.setCurrentValueCoin();
                            break;
                        case 6:
                            //user.newCoin();
                            break;
                        case 7:
                            exit=true;
                            break;
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
