import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class Portfolio {
    private float saldo;
    private int UserID;
    public static ArrayList<String> Account = new ArrayList<>();

    public Portfolio() throws FileNotFoundException {

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
        String name = Account.get(0);
        String surename = Account.get(1);
        String fullname= name+" "+surename;
        System.out.println("De volledige naam van de persoon is: "+fullname);
        //Account.clear();
        return fullname;
    }

    public void plotGraph(){

    }

    public void readFromFile(File fileName) throws FileNotFoundException {
        //File inputFile = new File("Accounts.txt");
        int i = 0;
        Scanner lineReader = new Scanner(fileName);
        Scanner wordReader = null;
        String currentLine;
        String word;
        Account.clear();
        while (lineReader.hasNextLine()) {       //Checken op EOF.
            currentLine = lineReader.nextLine(); //Lezen van de volgende lijn in de textfile.
            wordReader = new Scanner(currentLine);
            while (wordReader.hasNext()) {
                word = wordReader.next();
                i = i + 1;
                int Arraysize = Account.size();
                //if (Arraysize > 2) {
                    if (i == 1) {
                        Account.add(word);
                        System.out.println("Voornaam van de persoon: " + word);
                        //System.out.println("Dit is accounts: " + Account);

                    }
                    if (i == 2) {
                        Account.add(word);
                        System.out.println("Achternaam van de persoon: " + word);
                        //System.out.println("Dit is accounts: " + Account);
                    }
                    if (i == 3) {
                        Account.add(word);
                        System.out.println("Dit is woord 3: " + word);
                        //System.out.println("Dit is accounts: " + Account);
                    }
                    if (i == 4) {
                        Account.add(word);
                        System.out.println("Dit is woord 4: " + word);
                        //System.out.println("Dit is accounts: " + Account);
                    }
                    if (i == 5) {
                        Account.add(word);
                        System.out.println("Dit is woord 5: " + word);
                        System.out.println("Dit is accounts tot index 5: " + Account);
                    }
                    if (i == 6) {
                    Account.add(word);
                    }
                    if (i == 7) {
                    Account.add(word);
                    }
                    if (i == 8) {
                    Account.add(word);
                    System.out.println("Dit is accounts tot index 8: " + Account);
                }
                    // }
                //else
                /*{
                    System.out.println("Dit is accounts: " + Account);
                }*/
                /*ListIterator <String> gegevensIterator = Account.listIterator();
                while(gegevensIterator.hasNext()){
                    System.out.print(i + " ");
                    System.out.println(gegevensIterator.next());
                    i++;
                }*/

            }
            i = 0;

        }
        lineReader.close();
        wordReader.close();


    }

    public void getWeekValues(){

    }
}
