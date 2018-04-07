
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

        Scanner reader = new Scanner(System.in);
        System.out.println("Set the value of your coin for today");
        int currentValue = reader.nextInt();
        portfolio.Account.set(3, Integer.toString(currentValue));

        System.out.println("Aangepaste versie ArrayList: " + portfolio.Account);
        // Bij Meerdere accounts gebruik dit: int i=3; i=i+5; in een lus.

        FileWriter writer = new FileWriter("User.txt");
        BufferedWriter output = new BufferedWriter(writer);
        int j = 0;
        System.out.println("Size = " + portfolio.Account.size());
        for (String str : portfolio.Account) {
                //out.println(str);
                output.write(str);
                output.write(" ");
                j++;
                if (j == 5 || j==8) {
                    output.newLine();
                }
            }
        output.close();
        writer.close();
        Accounts acc=new Accounts();
        acc.updateDatabase("Monba",Integer.toString(currentValue));
        //portfolio.Account.clear();

        //return currentValue;
    }
}


