import java.sql.SQLOutput;
import java.util.Scanner;

public class Coin {
    private String nameCoin;
    private int valueCoin;   //Waarschijnlijk overbodig
    private int quantityCoin;//Waarschijnlijk overbodig
    private int currentValue;//Waarschijnlijk overbodig
    private int newValueCoin;//Waarschijnlijk overbodig

    public String setNameCoin(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Which crypto-coin would you like to add? ");
        String coin = reader.next();
        nameCoin=coin; //Waarschijnlijk overbodig
        return coin;
    }
    public int setValueCoin(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Type in the current value of this coin: ");
        int value = reader.nextInt();
        return value;
    }
    public int setQuantityCoin(){
        Scanner reader = new Scanner(System.in);
        System.out.println("How much do you want to own from "+nameCoin+"?");
        int quantity = reader.nextInt();
        return quantity;
    }
    public int setCurrentValueCoin(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Set the value of "+nameCoin+" for today");
        int currentValue=reader.nextInt();
        return currentValue;
    }
    //test
}
