import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class Portfolio {
    private float saldo;
    private int UserID;
    private static ArrayList<String> Accounts = new ArrayList<String>();
    File inputFile = new File("Accounts.txt");
    int i=0;
    Scanner lineReader = new Scanner(inputFile);
    Scanner wordReader = null;
    String currentLine;
    String word;

    public Portfolio() throws FileNotFoundException {
        while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
            wordReader = new Scanner(currentLine);
            while(wordReader.hasNext()) {
                word = wordReader.next();
                i = i+1;
                if (i==1) {
                    Accounts.add(word);
                    System.out.println("Dit is woord 1: "+word);
                    System.out.println("\nDit is accounts: "+Accounts);

                }
                if (i==2) {
                    Accounts.add(word);
                    System.out.println("Dit is woord 2: "+word);
                    System.out.println("\nDit is accounts: "+Accounts);
                }
                if (i==3) {
                    Accounts.add(word);
                    System.out.println("Dit is woord 3: "+word);
                    System.out.println("\nDit is accounts: "+Accounts);
                }
                if (i==4) {
                    Accounts.add(word);
                    System.out.println("Dit is woord 4: "+word);
                    System.out.println("\nDit is accounts: "+Accounts);
                }
                if (i==5){
                    Accounts.add(word);
                    System.out.println("Dit is woord 5: "+word);
                    System.out.println("\nDit is accounts: "+Accounts);
                }

            }
            i = 0;
        }
        lineReader.close();
        wordReader.close();
    }


    public float getQuantityCoin(){

        return saldo;
    }
    public String getCoinName()
    {
        String coinName="";
        return coinName;
    }

    public int getCoinValue()
    {
        int coinValue=0;

        return coinValue;
    }

    public String getName()
    {
        String nameUser = "";

        return nameUser;
    }

    public void plotGraph(){

    }

    public void readFromFile(File fileName)
    {

    }

    public void getWeekValues(){

    }
}
