import java.io.*;
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

    public void readFromFile() throws IOException {
        //File inputFile = new File("Accounts.txt");
        Account.clear();
        BufferedReader fileIn2 = new BufferedReader(new FileReader("User.txt"));
        String line=fileIn2.readLine();
        String parts[]=line.split(" ");
        String fileName = parts[0]+".txt";
        fileIn2.close();

        System.out.println("Dit is de naam: "+fileName);
        BufferedReader fileIn3= new BufferedReader(new FileReader(fileName));
        String line2=fileIn3.readLine();
        String parts2[]=line2.split(" ");
        fileIn3.close();

        int lengte=parts.length;
        System.out.println("Dit is de lengte: "+lengte);
        if(parts2.length==2 && !(parts.length>=5))
        {
            Account.add(parts2[0]);
            Account.add(parts2[1]);
        }
        else if(parts2.length == 5)
        {
            Account.add(parts2[0]);
            Account.add(parts2[1]);
            Account.add(parts2[2]);
            Account.add(parts2[3]);
            Account.add(parts2[4]);
        }
        else if(parts2.length>=8) //Hier misschien nog zien of we meer dan twee coins zullen toevoegen
        {
            System.out.println("We zitten hier");
            for (int j=0;j<lengte;j++)
            {
                Account.add(parts2[j]);
            }
            /*Account.add(parts2[0]);
            Account.add(parts2[1]);
            Account.add(parts2[2]);
            Account.add(parts2[3]);
            Account.add(parts2[4]);
            Account.add(parts2[5]);
            Account.add(parts2[6]);
            Account.add(parts2[7]);*/
        }



        System.out.println("Dit is accounts tot: " + Account);
        //fileIn3.close();


        /*Scanner lineReader = new Scanner(fileName);
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
                if (i == 1) {
                    Account.add(word);
                    System.out.println("Voornaam van de persoonbruh: " + word);
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


            }
            i = 0;

        }
        lineReader.close();
        wordReader.close();*/


    }

    public void getWeekValues(){

    }
}
