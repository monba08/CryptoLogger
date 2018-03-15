import java.util.Scanner;

public class Coin {
    private String nameCoin;
    private int valueCoin;
    private int quantityCoin;
    private int currentValue;
    private int newValueCoin;

    public String setNameCoin(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Which crypto-coin would you like to add? ");
        String coin = reader.next();
        nameCoin=coin;
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
    public void setCurrentValueCoin(){

    }
}
