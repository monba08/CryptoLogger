
import javax.sound.sampled.Port;
import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Coin {
    private String nameCoin;
    Portfolio portfolio;
    private int valueCoin;   //Waarschijnlijk overbodig
    private int quantityCoin;//Waarschijnlijk overbodig
    private int currentValue;//Waarschijnlijk overbodig
    private int newValueCoin;//Waarschijnlijk overbodig

    public Coin(int valueC, int quantityC, String nameC) {
        valueCoin = valueC;
        quantityCoin = quantityC;
        nameCoin = nameC;
    }

    public void setNameCoin(String coin) {
        // Scanner reader = new Scanner(System.in);
        //System.out.println("Which crypto-coin would you like to add? ");
        // String coin = reader.next();

        nameCoin = coin; //Waarschijnlijk overbodig

        //return coin;
    }

    public void setValueCoin(int value) {
        /*Scanner reader = new Scanner(System.in);
        System.out.println("Type in the current value of this coin: ");
        int value = 0;
        if(reader.hasNextInt())
        {
            value = reader.nextInt();
        }*/
        valueCoin = value;

        //return value;
    }

    public void setQuantityCoin(int quantity) {
        /*Scanner reader = new Scanner(System.in);
        System.out.println("How much do you want to own from "+nameCoin+"?");
        int quantity = 0;
        //reader.nextLine();
        if(reader.hasNextInt())
        {
            quantity = reader.nextInt();
        }*/
        quantityCoin = quantity;

        //return quantity;
    }

    public void setCurrentValueCoin() throws IOException {

        //File fout = new File("Accounts.txt");
        /*ListIterator<String> gegevensIterator = portfolio.Account.listIterator();
        String current;


        while(gegevensIterator.hasNext()){
            current = gegevensIterator.next();
            System.out.println(current);
            }*/
        /*FileWriter writer = new FileWriter("Accounts.txt",true);
        Writer output=new BufferedWriter(writer);*/
        Scanner reader = new Scanner(System.in);
        System.out.println("Set the value of " + nameCoin + " for today");
        int currentValue = reader.nextInt();
        portfolio.Account.set(3, Integer.toString(currentValue));
        System.out.println("Aangepaste versie ArrayList: " + portfolio.Account);
        // Bij Meerdere accounts gebruik dit: int i=3; i=i+5; in een lus.
        FileWriter writer = new FileWriter("Accounts.txt");
        BufferedWriter output = new BufferedWriter(writer);
        int j = 0;
        System.out.println("Size= " + portfolio.Account.size());
        PrintWriter out = new PrintWriter("Accounts.txt");

        /*for(String str: portfolio.Account) {


            out.print(str);
        }
        out.close();*/


        //for (int i = 0; i < portfolio.Account.size(); i++) {
            for (String str : portfolio.Account) {
                out.println(str);

                output.write(str);
                output.write(" ");

                j++;
                if (j == 5) {
                    output.newLine();
                }

            }
       // }

        output.close();
        writer.close();

        /* FileReader fr = new FileReader ("Accounts.txt");
        BufferedReader br = new BufferedReader (fr);
        String line = br.readLine();
        int count = 0;
        while (line != null) {
            String []parts = line.split(" ");
            for( String w : parts)
            {
                count++;
            }
            line = br.readLine();
            br.close();
            fr.close();
            if(count==4)
            {
                output.write(Integer.toString(currentValue));
            }
        }
        output.close();*/
        /*File file = new File("Accounts.txt");
        try(Scanner sc = new Scanner(new FileInputStream(file))){
            int count=0;
            while(sc.hasNext()){
                sc.next();
                count++;
                if(count==4)
                {
                    output.write(Integer.toString(currentValue));
                    output.close();
                }
            }
            System.out.println("Number of words: " + count);
        }*/
        //System.out.println("Het aantal woorden is: "+count);
        //return currentValue;
    }
}
    //test

