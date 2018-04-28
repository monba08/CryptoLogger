
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

        nameCoin = coin; //Waarschijnlijk overbodig

    }

    public void setValueCoin(int value) {

        valueCoin = value;

    }

    public void setQuantityCoin(int quantity) {

        quantityCoin = quantity;
    }

    public void setCurrentValueCoin(String name,int value) throws IOException {

        //Scanner reader = new Scanner(System.in);
        //System.out.println("If you have multiple coins, which one would you like to change the value of?");
        //String whichCoin=reader.nextLine();
        //System.out.println("Set the value of your coin for today");
        //int currentValue = reader.nextInt();
        String userName=portfolio.Account.get(0);
        //System.out.println("De naam van de gebruiker is: "+userName);

        int changeValueCoin = value;
        int grootteArrayList = portfolio.Account.size();
        for (int j = 2; j < grootteArrayList; j += 3) {
            if (portfolio.Account.get(j).contains(name)) {
                changeValueCoin = j;
            }
        }
        //System.out.println("Te veranderen coin is op index: "+changeValueCoin);

            portfolio.Account.set(changeValueCoin+1,Integer.toString(currentValue));


        /*
        if(portfolio.Account.get(2).contains(whichCoin)) {
            portfolio.Account.set(3, Integer.toString(currentValue));
        }else if(portfolio.Account.get(5).contains(whichCoin)) {
            portfolio.Account.set(6, Integer.toString(currentValue));
        }*/

        System.out.println("Aangepaste versie ArrayList: " + portfolio.Account);
        // Bij Meerdere accounts gebruik dit: int i=3; i=i+5; in een lus.

        FileWriter writer = new FileWriter(userName+".txt");
        FileWriter writer2=new FileWriter("User.txt");
        BufferedWriter output = new BufferedWriter(writer);
        BufferedWriter output2 = new BufferedWriter(writer2);
        int j = 0;
        System.out.println("Size = " + portfolio.Account.size());
        for (String str : portfolio.Account) {
                //out.println(str);
                output.write(str);
                output.write(" ");
                output2.write(str);
                output2.write(" ");
                j++;
                /*if (j == 5 || j==8) {
                    output.newLine();
                }*/
            }
        output.close();
        writer.close();
        output2.close();
        writer2.close();
        //Accounts acc=new Accounts();
        //acc.updateDatabase(userName,Integer.toString(currentValue));
        //portfolio.Account.clear();

        //return currentValue;
    }
}


