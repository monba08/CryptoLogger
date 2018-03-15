import java.lang.*;
import java.util.Scanner;


public class Accounts {

    private String coinType;
    private String nameUser;
    private int valueCoin;
    private int quantityCoin;
    private int date;


    //Dit zal later geïmplementeerd worden in een GUI.
    public void createNewAccount(){
        Coin coin = new Coin();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = reader.next();
        System.out.println("Enter a password for your account: ");
        String password = reader.next();

        //Parameters die we zullen doorgeven.
        nameUser = name;
        coinType=coin.setNameCoin();
        valueCoin=coin.setValueCoin();
        quantityCoin=coin.setQuantityCoin();
        reader.close();
    }

    public void logIn(String Name){

    }

    public void checkUser(String naam)
    {
        this.nameUser=naam;



    }
}
